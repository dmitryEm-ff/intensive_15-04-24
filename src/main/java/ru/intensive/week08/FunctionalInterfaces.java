package ru.intensive.week08;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        //Поставщик (Supplier):
        // Анонимный класс
        Supplier<String> supplier1 = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello, World!";
            }
        };
        // Лямбда-выражение
        Supplier<String> supplier2 = () -> "Hello, World!";

        String result1 = supplier1.get();
        System.out.println(result1);

        //Предикат (Predicate):
        // Анонимный класс
        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer number) {
                return number > 0;
            }
        };
        // Лямбда-выражение
        Predicate<Integer> predicate2 = number -> number > 0;

        boolean result2 = predicate1.test(5);
        System.out.println(result2);

        //Функция (Function):
        // Анонимный класс
        Function<Integer, String> function1 = new Function<Integer, String>() {
            @Override
            public String apply(Integer number) {
                return "Number: " + number;
            }
        };
        // Лямбда-выражение
        Function<Integer, String> function2 = number -> "Number: " + number;

        String result3 = function1.apply(5);
        System.out.println(result3);

        //Потребитель (Consumer):
        // Анонимный класс
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String message) {
                System.out.println("Message: " + message);
            }
        };
        // Лямбда-выражение
        Consumer<String> consumer2 = message -> System.out.println("Message: " + message);

        consumer1.accept("Hello!");

        //Компаратор (Comparator):
        // Анонимный класс
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num1.compareTo(num2);
            }
        };
        // Лямбда-выражение
        Comparator<Integer> comparator2 = (num1, num2) -> num1.compareTo(num2);

        int result4 = comparator1.compare(5, 1);
        System.out.println(result4);
    }
}
