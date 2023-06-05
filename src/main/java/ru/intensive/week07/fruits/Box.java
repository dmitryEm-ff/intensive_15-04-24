package ru.intensive.week07.fruits;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruits> {
    private final List<T> FRUIT_BOX;

    public Box() {
        this.FRUIT_BOX = new ArrayList<>();
    }

    public void add(T fruit) {
        FRUIT_BOX.add(fruit);
    }

    public float getWeight() {
        if (FRUIT_BOX.isEmpty()) {
            return 0.0f;
        } else {
            return FRUIT_BOX.size() * FRUIT_BOX.get(0).getWeight();
        }
    }

    public boolean compare(Box<?> another) {
        return this.getWeight() == another.getWeight();
    }

    public void transfer(Box<T> to) {
        to.FRUIT_BOX.addAll(this.FRUIT_BOX);
        this.FRUIT_BOX.clear();
    }
}
