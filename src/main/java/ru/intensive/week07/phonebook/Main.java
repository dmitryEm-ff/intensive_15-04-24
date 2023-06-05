package ru.intensive.week07.phonebook;

public class Main {
    public static void main(String[] args) {
        Telephone phonebook = new Telephone();
        phonebook.add("Иванов", "123456789");
        phonebook.add("Петров", "987654321");
        phonebook.add("Сидоров", "111222333");
        phonebook.add("Иванов", "444555666");
        phonebook.add("Петров", "777888999");

        System.out.println("Номера телефонов Иванова: " + phonebook.get("Иванов"));
        System.out.println("Номера телефонов Петрова: " + phonebook.get("Петров"));
        System.out.println("Номера телефонов Сидорова: " + phonebook.get("Сидоров"));
    }
}
