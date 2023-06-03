package ru.intensive.week06.copy;

import java.io.*;
import java.util.Random;

public class CopyExample {

    private static final int FILE_SIZE = 100 * 1024 * 1024;

    private static final String FILE_PATH = "src/main/java/ru/intensive/week06/copy/";

    /**
     * При буфере [1024] результаты:
     * FileReader\FileWriter. На выполнение ушло: 0.3667653 секунд
     * BufferedFileReader\BufferedFileWriter. На выполнение ушло: 0.3241605 секунд
     * FileInputStream\FileOutputStream. На выполнение ушло: 0.7588637 секунд
     * BufferedFileReader\BufferedFileWriter. На выполнение ушло: 0.184939 секунд
     *
     * При буфере [4096] результаты:
     * FileReader\FileWriter. На выполнение ушло: 0.4034454 секунд
     * BufferedFileReader\BufferedFileWriter. На выполнение ушло: 0.4926459 секунд
     * FileInputStream\FileOutputStream. На выполнение ушло: 0.345136 секунд
     * BufferedFileReader\BufferedFileWriter. На выполнение ушло: 0.1856381 секунд
     */
    public static void main(String[] args) {
        generateFile();

        copyReaderWriter();
        copyBufferedReaderWriter();
        copyFileInputOutputStream();
        copyBufferedInputOutputStream();

        imageCopy();

        deleteFiles(); //очистка файлов, можно вырубить
    }

    public static void generateFile() {
        Random random = new Random();
        int written = 0;

        try (FileWriter fileWriter = new FileWriter(FILE_PATH + "100mb.txt", false)) {
            while (written < FILE_SIZE) {
                String text = String.valueOf(random.nextInt(10)) + (char) (random.nextInt(26) + 'a');
                fileWriter.write(text);
                written += text.getBytes().length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл сгенерирован!");
    }

    private static void copyReaderWriter() {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(FILE_PATH + "100mb.txt");
             FileWriter fileWriter = new FileWriter(FILE_PATH + "copy.txt")) {
            char[] buffer = new char[4096];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("FileReader\\FileWriter. На выполнение ушло: " + duration + " секунд");
    }

    private static void copyBufferedReaderWriter() {
        long startTime = System.nanoTime();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(FILE_PATH + "100mb.txt"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_PATH + "copy.txt"))) {
            char[] buffer = new char[4096];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("BufferedFileReader\\BufferedFileWriter. На выполнение ушло: " + duration + " секунд");
    }


    private static void copyFileInputOutputStream() {
        long startTime = System.nanoTime();
        try (FileInputStream fileReader = new FileInputStream(FILE_PATH + "100mb.txt");
             FileOutputStream fileWriter = new FileOutputStream(FILE_PATH + "copy.txt")) {
            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("FileInputStream\\FileOutputStream. На выполнение ушло: " + duration + " секунд");
    }

    private static void copyBufferedInputOutputStream() {
        long startTime = System.nanoTime();
        try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(FILE_PATH + "100mb.txt"));
             BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(FILE_PATH + "copy.txt"))) {
            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("BufferedFileReader\\BufferedFileWriter. На выполнение ушло: " + duration + " секунд");
    }

    private static void imageCopy(){
        try (FileReader fileReader = new FileReader(FILE_PATH + "img.jpg");
             FileWriter fileWriter = new FileWriter(FILE_PATH + "img_bad_copy.jpg")) {
            char[] buffer = new char[4096];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Создан не рабочий jpg");

        try (FileInputStream fileReader = new FileInputStream(FILE_PATH + "img.jpg");
             FileOutputStream fileWriter = new FileOutputStream(FILE_PATH + "img_copy.jpg")) {
            byte[] buffer = new byte[4096];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Картинка скопирована через FileInputStream!");
    }

    private static void deleteFiles() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File output = new File(FILE_PATH + "copy.txt");
        if (output.delete()) {
            System.out.println("Копия удалена");
        } else {
            System.out.println("Не удалось удалить копию");
        }
        File input = new File(FILE_PATH + "100mb.txt");
        if (input.delete()) {
            System.out.println("Исходный файл удален");
        } else {
            System.out.println("Не удалось удалить исходный файл");
        }

        File image = new File(FILE_PATH + "img_copy.jpg");
        if (image.delete()) {
            System.out.println("Картинка удалена");
        } else {
            System.out.println("Не удалось удалить Картинку");
        }

        File badImage = new File(FILE_PATH + "img_bad_copy.jpg");
        if (badImage.delete()) {
            System.out.println("Битая картинка удалена");
        } else {
            System.out.println("Не удалось удалить Картинку");
        }
    }
}
