package ru.intensive.week04.callemulator;

public class Caller implements CallService{
    @Override
    public void printMessage() {
        System.out.println("Print to Terminal!");
    }
}
