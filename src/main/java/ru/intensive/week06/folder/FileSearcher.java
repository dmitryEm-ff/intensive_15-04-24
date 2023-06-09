package ru.intensive.week06.folder;

import java.io.File;

public class FileSearcher {

    private static final String FILE_PATH = "src/main/java/ru/intensive/";

    public static void main(String[] args) {
        File directory = new File(FILE_PATH);
        printDirectory(directory);
    }

    private static void printDirectory(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getPath());
                printDirectory(file);
            }
        }
    }
}
