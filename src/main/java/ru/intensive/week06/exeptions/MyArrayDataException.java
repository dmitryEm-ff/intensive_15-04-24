package ru.intensive.week06.exeptions;

import lombok.Getter;

@Getter
public class MyArrayDataException extends Throwable {
    private final int i;
    private final int j;

    public MyArrayDataException(int i, int j) {
        super("Неверные данные в ячейке [" + i + ", " + j + "]");
        this.i = i;
        this.j = j;
    }
}