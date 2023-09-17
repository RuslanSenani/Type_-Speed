package utils;

import colors.ConsoleColor;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class InputUtils {

    public static int requiredInt(String title) {
        int result = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(title + " :");
            result = scanner.nextInt();
        } catch (InputMismatchException exception) {
            System.out.println(ConsoleColor.RED_BOLD + "Zehmet Olmasa Deyeri Reqemlerle Daxil Edin");
        }
        return result;

    }


    public static String requiredString(String title) {
        String result=null;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println(title + " :");
            result =  scanner.nextLine();
        } catch (InputMismatchException exception) {
            System.out.println(ConsoleColor.RED_BOLD + "Zehmet Olmasa Deyeri Herflerle Daxil Edin");
        }
        return  result;
    }
}
