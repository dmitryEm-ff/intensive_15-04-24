package ru.intensive.week09;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * нужно на выходе получить список обьектов с 3я полями(строками),
 * каждому ключу из основной мапы должны соответствовать все комбинации
 * (key, value) из вспомогательной мапы
 */
public class Task01 {
    public static void main(String[] args) {
        Map<String, Map<String, String>> mp = new HashMap<>();

        mp.put("key1", new HashMap<>(){{
            put("Art1", "100");
            put("Max1", "200");
        }});

        mp.put("key2", new HashMap<>(){{
            put("Rita2", "300");
            put("Sasha2", "400");
            put("Igor2", "500");
        }});

        List<MapObject> list = mp.entrySet().stream()
                .flatMap(entry -> entry.getValue().entrySet().stream()
                        .map(e -> new MapObject(entry.getKey(), e.getKey(), e.getValue()))).collect(Collectors.toList());

        System.out.println(list);
    }
}

@Data
@AllArgsConstructor
class MapObject {
    private String key;
    private String name;
    private String value;

    @Override
    public String toString() {
        return "(" + key + ", " + name + ", " + value + ")";
    }
}
