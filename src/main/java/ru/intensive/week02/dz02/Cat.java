package ru.intensive.week02.dz02;

import java.util.concurrent.atomic.AtomicInteger;

public class Cat extends Animals{

    private static final AtomicInteger count = new AtomicInteger();

    public Cat() {
        super(
                characteristic.nextInt(200) + 100,
                0,
                characteristic.nextInt(2) + 1
        );
        count.incrementAndGet();
    }

    public static int getCount() {
        return count.get();
    }

    @Override
    public String toString() {
        return "Cat{" +
                "runLimit=" + runLimit +
                ", swimLimit=" + swimLimit +
                ", leapLimit=" + leapLimit +
                '}';
    }
}
