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

        Map<Character, String> resultMap = Arrays.stream(strings)
                .filter(str -> str.length() <= 10)
                .collect(Collectors.toMap(
                        str -> str.charAt(0),
                        str -> str,
                        BinaryOperator.maxBy(Comparator.comparingInt(String::length))
                ));

        System.out.println(resultMap);
    }
}
