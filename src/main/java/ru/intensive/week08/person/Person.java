package ru.intensive.week08.person;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}