package ru.intensive.week07;

import java.util.*;

public class CollectionsExmpl {
    public static void main(String[] args) {
        System.out.println("1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);");
        String[] array01 = new String[]{"Первый элемент", "Второй элемент"};
        System.out.println(Arrays.toString(array01));
        swapArr(array01, 0, 1);
        System.out.println(Arrays.toString(array01));
        System.out.println(System.lineSeparator());

        System.out.println("2. Написать метод, который преобразует массив в ArrayList;");
        String[] array02 = new String[]{"Первый элемент", "Второй элемент"};
        System.out.println("Массив " + Arrays.toString(array02));
        List<String> list = convertToList(array02);
        System.out.println("Лист " + list);
        System.out.println(System.lineSeparator());

        System.out.println("4 Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).\n" +
                " Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). \n" +
                "Посчитать, сколько раз встречается каждое слово. ");
        String[] words = {"apple", "banana", "orange", "pear", "apple", "grape", "kiwi", "banana", "peach", "orange"};
        uniqueWords(words);
    }

    public static <T> void swapArr(T[] array, int i, int j) {
        if (array.length < 2 || i > array.length - 1 || j > array.length - 1) {
            throw new IllegalArgumentException("Not valid array");
        }
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> ArrayList<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static void uniqueWords(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        System.out.println("Уникальные слова: " + map.keySet());
        System.out.println("Слово -> Кол-во повторов: " + map);
    }
}
