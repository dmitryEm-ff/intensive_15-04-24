package ru.intensive.week08;

@FunctionalInterface
interface ThreeFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

public class TreeFunctionExample {
    public static void main(String[] args) {
        // Лямбда-выражение 1
        ThreeFunction<Integer, Integer, Integer, Integer> sum = (a, b, c) -> a + b + c;
        int result1 = sum.apply(1, 2, 3);
        System.out.println("Сумма: " + result1);

        // Лямбда-выражение 2
        ThreeFunction<String, String, String, String> concat = (s1, s2, s3) -> s1 + s2 + s3;
        String result2 = concat.apply("Hello, ", "world", "!");
        System.out.println("Результат конкатенации: " + result2);
    }
}
