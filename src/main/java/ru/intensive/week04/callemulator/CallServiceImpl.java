package ru.intensive.week04.callemulator;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallServiceImpl implements CallService{
    private CallService callService;
    private int maxCallsPerMinute;
    private int lastCallsPerMinute;
    private long lastCallTime;
    private final Queue<Long> queue = new ConcurrentLinkedQueue<>();

    public CallServiceImpl(CallService callService, int maxCallsPerMinute) {
        this.callService = callService;
        this.maxCallsPerMinute = maxCallsPerMinute;
        this.lastCallsPerMinute = 0;
        this.lastCallTime = System.currentTimeMillis();
    }

    @Override
    public void printMessage() {
        long currentCallTime = System.currentTimeMillis();

        if (queue.peek() != null && currentCallTime - queue.peek() > 60000) {
            lastCallTime = queue.peek();
            lastCallsPerMinute--;
            queue.remove();
        }

        if (lastCallsPerMinute < maxCallsPerMinute) {
            callService.printMessage();
            lastCallsPerMinute++;
            queue.add(System.currentTimeMillis());
        } else {
            String formattedTime = dateFormat.format(new Date(System.currentTimeMillis()));
            System.out.printf("Limit reached! Print to Log! Current time is : %s%n", formattedTime);
        }
    }
}
