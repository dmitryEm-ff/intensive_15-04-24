package ru.intensive.week07.fruits;

public class Main {
    public static void main(String[] args) {
        Box<Apple> boxOfApples = new Box<>();
        Box<Orange> boxOfOranges = new Box<>();
        Box<Apple> anotherBoxOfApples = new Box<>();

        // Добавляем фрукты в коробки
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple());
        boxOfApples.add(new Apple()); //6.0f
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange());
        boxOfOranges.add(new Orange()); //6.0f

        // Сравниваем вес коробок
        System.out.println("Weight of boxOfApples: " + boxOfApples.getWeight());
        System.out.println("Weight of boxOfOranges: " + boxOfOranges.getWeight());
        System.out.println("boxOfApples.equals(boxOfOranges): " + boxOfApples.compare(boxOfOranges));
        System.out.println("boxOfApples.equals(anotherBoxOfApples): " + boxOfApples.compare(anotherBoxOfApples));

        // Пересыпаем фрукты из одной коробки в другую
        boxOfApples.transfer(anotherBoxOfApples);
        System.out.println("Weight of boxOfApples after transfer: " + boxOfApples.getWeight());
        System.out.println("Weight of anotherBoxOfApples after transfer: " + anotherBoxOfApples.getWeight());
    }
}
