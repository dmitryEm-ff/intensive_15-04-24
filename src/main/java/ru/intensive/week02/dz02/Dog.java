package ru.intensive.week02.dz02;

import java.util.concurrent.atomic.AtomicInteger;

public class Dog extends Animals{

    private static final AtomicInteger count = new AtomicInteger();

    public Dog() {
        super(
                characteristic.nextInt(300) + 200,
                characteristic.nextInt(20) + 10,
                characteristic.nextInt(4) + 2
        );
        count.incrementAndGet();
    }

    public static int getCount() {
        return count.get();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "runLimit=" + runLimit +
                ", swimLimit=" + swimLimit +
                ", leapLimit=" + leapLimit +
                '}';
    }
}
