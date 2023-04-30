package ru.intensive.week03;

public class MaskExample {
    private final int length;

    public MaskExample(int length) {
        this.length = length;
    }

    public String mapToMask(int number) {
        int numberLength = String.valueOf(number).length();
        if (numberLength > length) {
            return "Length must be less than " + length;
        }
        StringBuilder builder = new StringBuilder(String.valueOf(number));
        while (builder.length() != length) {
            builder.insert(0, "0");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        MaskExample test = new MaskExample(8);

        System.out.println(test.mapToMask(123));
        System.out.println(test.mapToMask(54321));
        System.out.println(test.mapToMask(12345678));
        System.out.println(test.mapToMask(987654321));
    }
}
