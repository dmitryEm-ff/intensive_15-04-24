package ru.intensive.week10.task01;

public class AlphabetThreads {
    private static int count = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        printer(3, 5);
    }

    public static void printer(int threadCount, int repeatCount) {
        for (int i = 0; i < threadCount; i++) {
            int letterIterator = i;
            Thread thread = new Thread(() -> {
                synchronized (lock) {
                    try {
                        char letter = (char) ('A' + letterIterator);
                        for (int j = 0; j < repeatCount; j++) {
                            while (count != letterIterator + 1) {
                                lock.wait();
                            }
                            System.out.println(letter);
                            if (count == threadCount) {
                                count = 1;
                            } else {
                                count++;
                            }
                            lock.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}