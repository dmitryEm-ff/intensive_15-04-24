package ru.intensive.week06.exeptions;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Размер массива должен быть 4х4");
    }
}