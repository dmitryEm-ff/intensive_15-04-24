package ru.intensive.week11.task01;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Task01 {

    private static final int FILE_SIZE = 100 * 1024 * 1024;

    private static final String FILE_PATH = "src/main/java/ru/intensive/week11/task01/";

    private static final AtomicBoolean running = new AtomicBoolean(true);

    static long fivePercent = FILE_SIZE / 20; // 5% от общего размера
    static long nextThreshold = fivePercent; // следующий порог для вывода сообщения
    static long totalCopied = 0;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<?> inputFuture = executor.submit(Task01::readUserInput);
        Future<?> outputFuture = executor.submit(Task01::printMessage);

        executor.shutdown();
    }

    private static void readUserInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (running.get()) {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("quit")) {
                    running.set(false);
                }
            }
        }
    }

    private static void printMessage() {
        try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(FILE_PATH + "100mb.txt"));
             BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(FILE_PATH + "copy.txt"))) {
            byte[] buffer = new byte[1024];
            int bytes;

            while ((bytes = fileReader.read(buffer)) != -1 && running.get()) {

                fileWriter.write(buffer, 0, bytes);
                totalCopied += bytes;

                long currentPercent = totalCopied * 100 / FILE_SIZE;
                if (totalCopied >= nextThreshold) {
                    System.out.println("Прогресс копирования: " + currentPercent + "%");
                    nextThreshold += fivePercent;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при копировании файла: " + e.getMessage());
        } finally {
            running.set(false);
        }
    }
}

/**
 * Реализация через Thread
 */
//    public static void main(String[] args) {
//        generateFile();
//
//        Thread inputThread = new Thread(Task01::readUserInput);
//        inputThread.start();
//        copyBufferedInputOutputStream();
//
////        deleteFiles();
//    }
//
//    public static void generateFile() {
//        Random random = new Random();
//        int written = 0;
//
//        try (FileWriter fileWriter = new FileWriter(FILE_PATH + "100mb.txt", false)) {
//            while (written < FILE_SIZE) {
//                String text = String.valueOf(random.nextInt(10)) + (char) (random.nextInt(26) + 'a');
//                fileWriter.write(text);
//                written += text.getBytes().length;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Файл сгенерирован!");
//    }
//
//    private static void copyBufferedInputOutputStream() {
//        try (BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(FILE_PATH + "100mb.txt"));
//             BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(FILE_PATH + "copy.txt"))) {
//            byte[] buffer = new byte[1024];
//            int bytes;
//
//            while ((bytes = fileReader.read(buffer)) != -1 && running.get()) {
//
//                fileWriter.write(buffer, 0, bytes);
//                totalCopied += bytes;
//
//                long currentPercent = totalCopied * 100 / FILE_SIZE;
//                if (totalCopied >= nextThreshold) {
//                    System.out.println("Прогресс копирования: " + currentPercent + "%");
//                    nextThreshold += fivePercent;
//
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println("Ошибка при копировании файла: " + e.getMessage());
//        }
//    }
//
//    private static void deleteFiles() {
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        File output = new File(FILE_PATH + "copy.txt");
//        if (output.delete()) {
//            System.out.println("Копия удалена");
//        } else {
//            System.out.println("Не удалось удалить копию");
//        }
//    }
//
//    private static void readUserInput() {
//        try (Scanner scanner = new Scanner(System.in)) {
//            while (running.get()) {
//                String input = scanner.nextLine();
//                if (input.equalsIgnoreCase("quit")) {
//                    running.set(false);
//                }
//            }
//        }
//    }
//}