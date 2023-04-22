package ru.intensive.week01;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        String[] origin = new String[]{"one", "two", "three"};
        String[] arrayCopy = new String[3];
        System.arraycopy(origin, 0, arrayCopy, 0, 3);

        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(arrayCopy));
    }
}
