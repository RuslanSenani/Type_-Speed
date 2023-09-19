import colors.ConsoleColor;
import dinamicArray.DynamicRandomArray;

import inserface.IFileOperation;
import manager.ApiManager;

import services.TxtFile;
import services.TypeSpeed;
import utils.InputUtils;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        IFileOperation fileOperation = new TxtFile();


        int wordCount = InputUtils.requiredInt("Zehmet Olmasa Nece Sozle Baslmaq Isteyirsinizse Reqem Olaraq Yazin Yazin Misal(5,10,30)");
        try (ExecutorService executor = Executors.newFixedThreadPool(2)) {
            Runnable fetchData = () -> ApiManager.runProcess(wordCount);
            executor.execute(fetchData);
            executor.shutdown();
        } catch (Exception exception) {
            System.out.println(ConsoleColor.RED_BOLD + exception.getMessage());
        }

        ApiManager.getStart();
        fileOperation.readFromFile();
        long startTime = System.currentTimeMillis();
        long minutes = 600 * 1000;
        while (true) {
            long atMoment = System.currentTimeMillis();
            DynamicRandomArray.getRandomWord(wordCount);
            if (atMoment - startTime >= minutes) {
                System.out.println(ConsoleColor.RED_BOLD + "Wrong Word Count = " + TypeSpeed.getWrongWordCount());
                System.out.println(ConsoleColor.GREEN_BRIGHT + "Success Word Count = " + TypeSpeed.getSuccessWordCount());
                System.out.println(ConsoleColor.GREEN_BRIGHT + "PWD = " + TypeSpeed.WPM(minutes));
                System.out.println(ConsoleColor.GREEN_BRIGHT + "Percent = " + TypeSpeed.percent());
                break;
            }
        }


    }
}