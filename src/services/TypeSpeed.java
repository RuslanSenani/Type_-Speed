package services;

import java.util.ArrayList;

public class TypeSpeed {
    private final static ArrayList<String> successWord = new ArrayList<String>();
    private final static ArrayList<String> wrongWord = new ArrayList<String>();

    public static void addSuccessWord(String successValue) {
        successWord.add(successValue);
    }

    public static void addWrongWord(String wrongValue) {
        wrongWord.add(wrongValue);
    }

    public static int getWrongWordCount() {
        return wrongWord.size();
    }

    public static int getSuccessWordCount() {
        return successWord.size();
    }


    public static double WPM(double millisecond) {
//        Yazma Hızı (WPM) = (100 / 5) * 60 = 120 WPM
//        Doğruluk Oranı (%) = (90 / 100) * 100 = 90%

        double WPM = ((getSuccessWordCount() + getSuccessWordCount()) / millisecond * 60);
        return WPM;
    }

    public static double percent() {

        double PRCNT = (((double) getSuccessWordCount() / (getSuccessWordCount() + getWrongWordCount()) * 100));
        return  PRCNT;
    }


}
