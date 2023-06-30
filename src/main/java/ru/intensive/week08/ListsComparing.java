package ru.intensive.week08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * -----Вставка в начало быстрее LinkedList-----
 * ArrayList вставка в начало: 2061400 ns
 * LinkedList вставка в начало: 423300 ns
 *
 * -----Вставка в конец быстрее ArrayList-----
 * ArrayList вставка в конец: 41300 ns
 * LinkedList вставка в конец: 50200 ns
 *
 * -----Вставка в середину быстрее ArrayList-----
 * ArrayList вставка в середину: 502000 ns
 * LinkedList вставка в середину: 14392800 ns
 *
 * -----Выбор рандом быстрее ArrayList-----
 * ArrayList рандом: 399200 ns
 * LinkedList берем рандом: 8803700 ns
 */
public class ListsComparing {
    public static void main(String[] args) {
        int size = 10000;
        int insertions = 1000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        // Заполняем списки
        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // Вставка в начало
        measureTime(arrayList, linkedList, insertions, PlaceEnum.BEGINNING);

        // Вставка в конец
        measureTime(arrayList, linkedList, insertions, PlaceEnum.END);

        // Вставка в середину
        measureTime(arrayList, linkedList, insertions, PlaceEnum.MIDDLE);

        // Запрос рандомного элемента
        measureTime(arrayList, linkedList, insertions, PlaceEnum.RANDOM);
    }

    private static void measureTime(List<Integer> arrayList, List<Integer> linkedList, int insertions, PlaceEnum operation) {
        Random rand = new Random();
        long start, end;

        switch (operation) {
            case BEGINNING:
                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    arrayList.add(0, i);
                }
                end = System.nanoTime();
                System.out.println("ArrayList вставка в начало: " + (end - start) + " ns");

                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    linkedList.add(0, i);
                }
                end = System.nanoTime();
                System.out.println("LinkedList вставка в начало: " + (end - start) + " ns");
                break;

            case END:
                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    arrayList.add(i);
                }
                end = System.nanoTime();
                System.out.println("ArrayList вставка в конец: " + (end - start) + " ns");

                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    linkedList.add(i);
                }
                end = System.nanoTime();
                System.out.println("LinkedList вставка в конец: " + (end - start) + " ns");
                break;

            case MIDDLE:
                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    arrayList.add(arrayList.size() / 2, i);
                }
                end = System.nanoTime();
                System.out.println("ArrayList вставка в середину: " + (end - start) + " ns");

                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    linkedList.add(linkedList.size() / 2, i);
                }
                end = System.nanoTime();
                System.out.println("LinkedList вставка в середину: " + (end - start) + " ns");
                break;

            case RANDOM:
                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    arrayList.get(rand.nextInt(arrayList.size()));
                }
                end = System.nanoTime();
                System.out.println("ArrayList берем рандом: " + (end - start) + " ns");

                start = System.nanoTime();
                for (int i = 0; i < insertions; i++) {
                    linkedList.get(rand.nextInt(linkedList.size()));
                }
                end = System.nanoTime();
                System.out.println("LinkedList берем рандом: " + (end - start) + " ns");
                break;
        }
    }

    public enum PlaceEnum {
        BEGINNING,
        MIDDLE,
        END,
        RANDOM
    }
}