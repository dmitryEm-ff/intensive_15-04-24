package ru.intensive.week02.dz02;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Animals {
    protected int runLimit;
    protected int swimLimit;
    protected int leapLimit;

    protected static Random characteristic = new Random();

    public Animals(int runLimit, int swimLimit, int leapLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.leapLimit = leapLimit;
    }

    public boolean run(int meters) {
        return runLimit >= meters;
    }

    public boolean swim(int meters) {
        return swimLimit >= meters;
    }

    public boolean leap(int meters) {
        return leapLimit >= meters;
    }
}
