package ru.intensive.week04;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise12 {

    private static final AtomicInteger counter = new AtomicInteger();

    public void printToTerminal() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(10, 6000));
            System.out.println("Printing to terminal!!!");
            counter.incrementAndGet();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Thread Interrupted");
        }
    }

    public void printToLog() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Printing to Log!");
    }

    public static void main(String[] args) throws InterruptedException {
        Exercise12 exercise12 = new Exercise12();
        long start = System.currentTimeMillis();
        while (true) {
            long current = System.currentTimeMillis();
            if (counter.get() < 10) {
                exercise12.printToTerminal();
            } else {
                exercise12.printToLog();
            }
            if (current - start > 60000) {
                counter.set(0);
                start = System.currentTimeMillis();
            }
        }
    }
}