package ru.intensive.week10.task02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Task02ExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = new int[1_000_000];
        // Заполняем массив значениями
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Long>> futures = new ArrayList<>();

        // Разбиваем массив на 5 частей и создаем задачи для каждой части
        for (int i = 0; i < 5; i++) {
            int startIndex = i * 200_000;
            int endIndex = (i + 1) * 200_000;

            SumTask task = new SumTask(array, startIndex, endIndex);
            Future<Long> future = executorService.submit(task);
            futures.add(future);
        }

        // Суммируем результаты всех задач
        long totalSum = 0;
        for (Future<Long> future : futures) {
            totalSum += future.get();
        }

        System.out.println("Total sum: " + totalSum);

        executorService.shutdown();
    }

    static class SumTask implements Callable<Long> {
        private final int[] array;
        private final int startIndex;
        private final int endIndex;

        public SumTask(int[] array, int startIndex, int endIndex) {
            this.array = array;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }

        @Override
        public Long call() {
            long sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += array[i];
            }
            return sum;
        }
    }
}