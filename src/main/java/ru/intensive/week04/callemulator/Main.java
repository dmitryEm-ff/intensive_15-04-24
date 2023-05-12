package ru.intensive.week04.callemulator;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CallService caller = new Caller();
        CallService callService = new CallServiceImpl(caller, 10);
        DelayEmulator emulator = new DelayEmulator(callService);

        while (true) {
            emulator.applyDelay();
        }
    }
}
