package ru.intensive.week04;

abstract class AnonymousCookable {
    public abstract void cook(String str);
}

class Banana extends AnonymousCookable {

    @Override
    public void cook(String str) {
        System.out.printf("Cooking: %s", str);
    }
}

class Food {
    public void prepare(AnonymousCookable cookable, String str) {
        cookable.cook(str);
    }

    public static void main(String[] args) {
        Food food = new Food();
        food.prepare(new Banana(), "Banana");
    }
}