package ru.intensive.week08;

import java.util.HashSet;
import java.util.Set;

public class ExtendedHashSet<E> extends HashSet<E> {

    // Метод для объединения множеств
    public Set<E> union(Set<E> set) {
        Set<E> result = new HashSet<>(this);
        result.addAll(set);
        return result;
    }

    // Метод для пересечения множеств
    public Set<E> intersect(Set<E> set) {
        Set<E> result = new HashSet<>(this);
        result.retainAll(set);
        return result;
    }

    public static void main(String[] args) {
        ExtendedHashSet<Integer> set1 = new ExtendedHashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        ExtendedHashSet<Integer> set2 = new ExtendedHashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> unionSet = set1.union(set2);
        System.out.println("Объединение множеств: " + unionSet);

        Set<Integer> intersectSet = set1.intersect(set2);
        System.out.println("Пересечение множеств: " + intersectSet);
    }
}