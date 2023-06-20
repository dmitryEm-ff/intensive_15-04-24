package ru.intensive.week08.person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 25));
        persons.add(new Person("Bob", 30));
        persons.add(new Person("Charlie", 20));
        persons.add(new Person("John", 25));
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Michael", 40));
        persons.add(new Person("Emily", 22));
        persons.add(new Person("David", 35));
        persons.add(new Person("Sarah", 28));
        persons.add(new Person("Daniel", 32));
        persons.add(new Person("Olivia", 27));
        persons.add(new Person("James", 45));
        persons.add(new Person("Sophia", 20));

        // Компаратор по имени с использованием лямбда-выражения
        Comparator<Person> nameComparator = (p1, p2) -> p1.getName().compareTo(p2.getName());

        // Компаратор по возрасту с использованием лямбда-выражения
        Comparator<Person> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());

        // Сортировка списка с использованием компаратора по имени
        persons.sort(nameComparator);
        System.out.println("Сортировка по имени:");
        persons.forEach(System.out::println);

        System.out.println(System.lineSeparator());

        // Сортировка списка с использованием компаратора по возрасту
        persons.sort(ageComparator);
        System.out.println("Сортировка по возрасту:");
        persons.forEach(System.out::println);
    }
}