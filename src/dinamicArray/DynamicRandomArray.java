package dinamicArray;

import colors.ConsoleColor;
import services.TypeSpeed;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Random;

public class DynamicRandomArray {

    private final static ArrayList<String> arrayList = new ArrayList<String>();
    private final static ArrayList<String> typedArrayList = new ArrayList<String>();

    public static void addToArray(String value) {
        arrayList.add(value);
    }

    public static void getRandomWord(int rnd) {
        Random random = new Random();

        String randValue = arrayList.get(random.nextInt(rnd));

        System.out.println(ConsoleColor.BLUE_BOLD + randValue);
        String typedWord = InputUtils.requiredString("Type");
        if (typedWord.equals(randValue)) {
            TypeSpeed.addSuccessWord(typedWord);
            System.out.println(ConsoleColor.GREEN_BOLD + "+");
        } else {
            TypeSpeed.addWrongWord(typedWord);
            System.out.println(ConsoleColor.RED_BOLD + "-");
        }


    }


}
