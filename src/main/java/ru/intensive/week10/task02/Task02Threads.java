package ru.intensive.week10.task02;

import java.util.ArrayList;
import java.util.List;

public class Task02Threads {
    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[1_000_000];
        // Заполняем массив значениями
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        List<SumThread> threads = new ArrayList<>();
        List<Long> sums = new ArrayList<>();

        // Создаем и запускаем потоки
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200_000;
            int endIndex = startIndex + 200_000;

            SumThread thread = new SumThread(array, startIndex, endIndex);
            threads.add(thread);
            thread.start();
        }

        // Ожидаем завершения всех потоков
        for (SumThread thread : threads) {
            thread.join();
            sums.add(thread.getSum());
        }

        // Суммируем результаты всех потоков
        long totalSum = 0;
        for (long sum : sums) {
            totalSum += sum;
        }

        System.out.println("Total sum: " + totalSum);
    }

    static class SumThread extends Thread {
        private final int[] array;
        private final int startIndex;
        private final int endIndex;
        private long sum;

        public SumThread(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public void run() {
            sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += array[i];
            }
        }

        public long getSum() {
            return sum;
        }
    }
}