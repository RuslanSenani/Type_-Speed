package services;

import colors.ConsoleColor;
import dinamicArray.DynamicRandomArray;
import enums.StaticValues;
import inserface.IFileOperation;

import java.io.*;


public class TxtFile implements IFileOperation {
    @Override
    public void writeToFile(String value) {
        try {
            File file = new File(StaticValues.FILE_PATH.getPath());
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter write = new BufferedWriter(writer);
            write.write(value);
            write.newLine();
            write.close();
        } catch (IOException ex) {
            System.err.println("File Writer Exception: " + ex.getMessage());
        }

    }

    @Override
    public void readFromFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(StaticValues.FILE_PATH.getPath());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String txtLine;
            while ((txtLine = bufferedReader.readLine()) != null) {

                DynamicRandomArray.addToArray(txtLine);
            }
            fileInputStream.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }finally {
            System.out.println("Start !! : ");
        }
    }

    @Override
    public void clearFile() {
        try {
            FileWriter dosyaYazici = new FileWriter(StaticValues.FILE_PATH.getPath());
            dosyaYazici.write("");
            dosyaYazici.close();
        } catch (IOException ex) {
            System.out.println(ConsoleColor.RED_BOLD + ex.getMessage());
        }
    }


}
