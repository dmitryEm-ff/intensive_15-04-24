package ru.intensive.week09;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * На основе списка строк сформировать мапу
 *    (key, value) = ("1я буква в строке", "Строка максимальной длины из тех что начинаются на данную букву,
 *    но при этом длина не превышающая 10, если таковой нет, в качестве значения null")
 */
public class Task02 {
    public static void main(String[] args) {
        String[] strings = {"Astra", "Gorod Moskva", "River", "Ruslan", "Albatross", "Gorod"};

        BinaryOperator<String> func2 = (x1, x2) -> {
            if (x1 == null) {
                return x2.length() <= 10 ? x2 : null;
            } else if (x1.length() <= 10 && x2.length() <= 10) {
                return x1.length() > x2.length() ? x1 : x2;
            } else if (x1.length() <= 10) {
                return x1;
            } else if (x2.length() <= 10) {
                return x2;
            } else {
                return null;
            }
        };

        Map<Character, Optional<String>> resultMap = Arrays.stream(strings)
                .collect(Collectors.groupingBy(str -> str.charAt(0),
                        Collectors.reducing(func2)));

        resultMap.entrySet().stream()
                .filter(e -> e.getValue().isPresent() && e.getValue().get().length() > 10)
                .forEach(e -> e.setValue(Optional.empty()));

        System.out.println(resultMap);
    }
}
