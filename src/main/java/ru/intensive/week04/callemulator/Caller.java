package ru.intensive.week04.callemulator;

import java.util.Date;

public class Caller implements CallService{
    @Override
    public void printMessage() {
        String formattedTime = dateFormat.format(new Date(System.currentTimeMillis()));
        System.out.printf("Print to Terminal! Current time is : %s%n", formattedTime);
    }
}
