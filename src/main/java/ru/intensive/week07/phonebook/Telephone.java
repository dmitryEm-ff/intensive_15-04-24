package ru.intensive.week07.phonebook;

import java.util.*;

public class Telephone {

    private final Map<String, Set<String>> PHONEBOOK;

    public Telephone() {
        this.PHONEBOOK = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        Set<String> phones = PHONEBOOK.getOrDefault(surname, new HashSet<>());
        phones.add(phoneNumber);
        PHONEBOOK.put(surname, phones);
    }

    public Set<String> get(String surname) {
        return PHONEBOOK.getOrDefault(surname, Collections.emptySet());
    }
}
