package ru.intensive.week03;

public class InitExample {
    private static final String STR = getConstant();
    private String string = getString();

    public InitExample(String s) {
        System.out.println(s + "\nЗвучал мне долго голос нежный\n");
        System.out.println("И снились милые черты.\n");
    }

    static {
        System.out.println("Я помню чудное мгновенье:\n");
    }

    {
        System.out.println("Как гений чистой красоты.\n");
        System.out.println(System.lineSeparator());
    }

    static {
        System.out.println("Передо мной явилась ты,\n");
    }

    {
        System.out.println("В томленьях грусти безнадежной,\n");
    }

    public static void main(String[] args) {
        new InitExample("В тревогах шумной суеты,\n");
    }

    public static String getConstant() {
        System.out.println("Александр Пушкин");
        System.out.println(System.lineSeparator());
        return "CONST";
    }

    public static String getString() {
        System.out.println("Как мимолетное виденье,\n");
        return "str";
    }
}