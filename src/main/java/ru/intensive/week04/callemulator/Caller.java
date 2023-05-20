package ru.intensive.week04.callemulator;

import java.util.Date;

public class Caller implements CallService{
    @Override
    public void printMessage() {
        System.out.printf("Print to Terminal! Current time is : %s%n", doFormat(System.currentTimeMillis()));
    }
}
