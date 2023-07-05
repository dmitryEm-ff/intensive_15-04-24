package ru.intensive.week10.task03;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Task03 {
    private static final AtomicInteger sharedNumber = new AtomicInteger();
    private static final CyclicBarrier barrier = new CyclicBarrier(4);
    private static final AtomicBoolean isRunning = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        Thread generator = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    int number = new Random().nextInt(100);
                    System.out.println("Главный поток сгенерировал " + (i + 1) + " число: " + number);
                    sharedNumber.set(number);
                    barrier.await();
                    Thread.sleep(1000);
                }
                System.out.println("Цикл закончен");
                isRunning.set(false); // Устанавливаем флаг завершения цикла
                barrier.await(); // Разблокируем потоки-рабочие, чтобы они могли проверить флаг и выйти
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });

        Thread[] workers = new Thread[3];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Thread(() -> {
                try {
                    while (isRunning.get() || barrier.getNumberWaiting() > 0) {
                        barrier.await();
                        if (!isRunning.get()) {
                            break; // Выходим из цикла, если флаг завершения цикла установлен
                        }
                        System.out.println(Thread.currentThread().getName() + " " + sharedNumber.get());
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        generator.start();
        for (Thread worker : workers) {
            worker.start();
        }

        generator.join();
        for (Thread worker : workers) {
            worker.join();
        }
    }
}