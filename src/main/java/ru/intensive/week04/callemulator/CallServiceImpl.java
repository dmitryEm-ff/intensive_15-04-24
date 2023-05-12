package ru.intensive.week04.callemulator;

public class CallServiceImpl implements CallService{
    private CallService callService;
    private int maxCallsPerMinute;
    private int lastCallsPerMinute;
    private long lastCallTime;

    public CallServiceImpl(CallService callService, int maxCallsPerMinute) {
        this.callService = callService;
        this.maxCallsPerMinute = maxCallsPerMinute;
        this.lastCallsPerMinute = 0;
        this.lastCallTime = System.currentTimeMillis();
    }

    @Override
    public void printMessage() {
        long currentCallTime = System.currentTimeMillis();

        if (currentCallTime - lastCallTime > 60000) {
            lastCallTime = System.currentTimeMillis();
            lastCallsPerMinute = 0;
        }

        if (lastCallsPerMinute < maxCallsPerMinute) {
            callService.printMessage();
            lastCallsPerMinute++;
        } else {
            System.out.println("Limit reached! Print to Log!");
        }
    }
}
