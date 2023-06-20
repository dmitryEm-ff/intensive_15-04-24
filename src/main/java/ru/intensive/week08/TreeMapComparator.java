package ru.intensive.week08;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapComparator {
    public static void main(String[] args) {
        Comparator<String> comparator = (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return s1.length() - s2.length();
            } else {
                return s1.compareTo(s2);
            }
        };

        Map<String, String> treeMap = new TreeMap<>(comparator);
        treeMap.put("abc", "abc");
        treeMap.put("abcd", "abcd");
        treeMap.put("ab", "ab");
        treeMap.put("fedc", "fedc");

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}
