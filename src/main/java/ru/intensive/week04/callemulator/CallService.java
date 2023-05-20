package ru.intensive.week04.callemulator;

import java.text.SimpleDateFormat;

public interface CallService {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    void printMessage();
}
