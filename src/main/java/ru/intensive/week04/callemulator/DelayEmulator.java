package ru.intensive.week04.callemulator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DelayEmulator {
    private final Random random = new Random();
    private CallService callService;

    public DelayEmulator(CallService callService) {
        this.callService = callService;
    }

    public void applyDelay() throws InterruptedException {
        Thread.sleep(ThreadLocalRandom.current().nextInt(10, 6000));
        callService.printMessage();
    }
}
