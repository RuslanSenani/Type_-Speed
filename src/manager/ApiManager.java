package manager;

import colors.ConsoleColor;
import enums.StaticValues;
import inserface.ICheckConnection;
import inserface.IFileOperation;
import services.CheckInternetConnection;
import services.TxtFile;

import java.net.URL;
import java.util.Scanner;

public class ApiManager {
    public static void runProcess(int count) {

        ICheckConnection connection = new CheckInternetConnection();
        connection.checkConnection();

        Scanner scanner;
        IFileOperation fileOperation = new TxtFile();

        try {
            fileOperation.clearFile();
            for (int i = 0; i < count; i++) {
//                double progress = (double) i / count * 100;
//                System.out.printf("Process: %.2f%%%n", progress);
                URL url = new URL(StaticValues.GET_API_URL.getPath());
                scanner = new Scanner(url.openStream());
                String word = scanner.useDelimiter("\\A").nextLine().split("\"")[1];
                fileOperation.writeToFile(word);
                Thread.sleep(500);
            }
        } catch (Exception ex) {
            System.out.println(ConsoleColor.RED_BOLD + ex.getMessage());
        } finally {
            //System.out.println("Progress: 100%");
            System.out.println("Start ");

        }
    }


    public static void getStart() {

        try {
            for (int i = 3; i > 0; i--) {
                Thread.sleep(1000);
                System.out.println("Ready :" + i);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
