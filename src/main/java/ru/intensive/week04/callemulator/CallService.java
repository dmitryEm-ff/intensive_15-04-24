package ru.intensive.week04.callemulator;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface CallService {
    final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    void printMessage();

    default String doFormat(long time) {
        return dateFormat.format(new Date(time));
    }
}
