package ru.intensive.week09;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * На основе списка строк сформировать мапу
 *    (key, value) = ("1я буква в строке", "Строка максимальной длины из тех что начинаются на данную букву,
 *    но при этом длина не превышающая 10, если таковой нет, в качестве значения null")
 */
public class Task02 {
    public static void main(String[] args) {
//        Map<String, String> map = list.stream().collect(Collectors.groupingBy(
//                s -> s.substring(0, 1),
//                Collectors.collectingAndThen(
//                        Collectors.maxBy(Comparator.comparingInt(String::length)),
//                        optional -> optional.filter(o -> o.length() <= 10).orElse(null)
//                )
//        ));
//
//        map.forEach((k, v) -> System.out.println(k + " " + v));


        List<String> list = List.of("Astra", "Gorod Moskva", "River", "Ruslan", "Albatross", "Gorod");

        BinaryOperator<String> func2 = (x1, x2) -> {
            if (x1 == null) {
                if (x2.length() > 10) {
                    return null;
                } else {
                    return x2;
                }
            } else {
                if (x1.length() >= 10 && x2.length() >= 10) {
                    return null;
                } else if (x1.length() >= 10) {
                    return x2;
                } else if (x2.length() >= 10) {
                    return x1;
                } else {
                    return x1.compareTo(x2) > 0 ? x1 : x2;
                }
            }
        };

        Map<Character, String> map = list.stream().collect(Collectors.groupingBy(
                    c -> c.charAt(0),
                    Collectors.reducing(null, func2))
        );

        System.out.println(map);
    }
}
