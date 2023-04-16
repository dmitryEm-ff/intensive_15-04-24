package ru.intensive.week01;

import java.util.Arrays;

public class DZ02 {
    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
        }
        System.out.println(Arrays.toString(array));
        System.out.println(System.lineSeparator());

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] empty = new int[8];
        for (int i = 0; i < empty.length; i++) {
            empty[i] = i * 3;
        }
        System.out.println(Arrays.toString(empty));
        System.out.println(System.lineSeparator());

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] twice = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < twice.length; i++) {
            twice[i] = twice[i] < 6 ? twice[i] * 2 : twice[i];
        }
        System.out.println(Arrays.toString(twice));
        System.out.println(System.lineSeparator());

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] sq = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        for (int i = 0; i < sq.length; i++) {
            sq[i][i] = 1;
        }
        for (int[] i : sq) {
            System.out.println(Arrays.toString(i));
        }
        System.out.println(System.lineSeparator());

        //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] minMax = new int[]{5, 3, 2, 11, 4, 8, 9, 1};
        int min = minMax[0], max = minMax[0];
        for (int j : minMax) {
            if (j < min) {
                min = j;
            } else if (j > max) {
                max = j;
            }
        }
        System.out.println("Min : " + min + ", Max : " + max);
        System.out.println(System.lineSeparator());

        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
        в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
        граница показана символами ||, эти символы в массив не входят.
         */
        int[] balanceOne = new int[]{2, 2, 2, 1, 2, 2, 10, 1};
        int[] balanceTwo = new int[]{1, 1, 1, 2, 1};
        System.out.println(checkBalance(balanceOne));
        System.out.println(checkBalance(balanceTwo));
        System.out.println(System.lineSeparator());

        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
        при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
        Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
         */
        int[] circle = new int[]{3, 5, 6, 1};
        int n = -2;
        circle(circle, n);
        System.out.println(Arrays.toString(circle));
        System.out.println(System.lineSeparator());
    }

    public static boolean checkBalance(int[] array) {
        int size = 0, l = 0, r = array.length - 1, leftSum = 0, rightSum = 0;
        while (size != array.length) {
            if (leftSum <= rightSum) {
                leftSum += array[l];
                l++;
            } else {
                rightSum += array[r];
                r--;
            }
            size++;
        }
        return leftSum == rightSum;
    }

    public static void circle(int[] array, int n) {
        int counter = Math.abs(n);
        while (counter != 0) {
            int a = n > 0 ? array[0] : array[array.length - 1];
            int i = n > 0 ? 0 : array.length - 1;
            if (n > 0) {
                for (; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
            } else {
                for (; i > 0; i--) {
                    array[i] = array[i - 1];
                }
            }
            array[i] = a;
            counter--;
        }
    }
}
