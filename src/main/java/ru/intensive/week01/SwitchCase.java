package ru.intensive.week01;

import java.util.Random;

public class SwitchCase {
    private static final Random dice = new Random();

    public static void main(String[] args) {
        switch (rand()) {
            case (1) :
                System.out.println("One");
                break;
            case (2) :
                System.out.println("Two");
                break;
            case (3) :
                System.out.println("Three");
                break;
            case (4) :
                System.out.println("Four");
                break;
            case (5) :
                System.out.println("Five");
                break;
            case (6) :
                System.out.println("Six");
                break;
            default:
                System.out.println("Zero");
        }
    }

    public static int rand() {
        return dice.nextInt(6);
    }
}
