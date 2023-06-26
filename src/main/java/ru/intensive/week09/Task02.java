package ru.intensive.week09;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * На основе списка строк сформировать мапу
 *    (key, value) = ("1я буква в строке", "Строка максимальной длины из тех что начинаются на данную букву,
 *    но при этом длина не превышающая 10, если таковой нет, в качестве значения null")
 */
public class Task02 {
    public static void main(String[] args) {
        List<String> list = List.of("Astra", "Gorod Moskva", "River", "Ruslan", "Albatross");
        Map<String, String> map = list.stream().collect(Collectors.groupingBy(
                s -> s.substring(0, 1),
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(String::length)),
                        optional -> optional.filter(o -> o.length() <= 10).orElse(null)
                )
        ));

        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
