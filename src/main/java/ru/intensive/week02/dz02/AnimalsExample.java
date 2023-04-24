package ru.intensive.week02.dz02;

public class AnimalsExample {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        System.out.println(cat);
        System.out.println(dog);

        System.out.println(System.lineSeparator());
        System.out.println(cat.run(250));
        System.out.println(cat.swim(0));
        System.out.println(cat.leap(2));

        System.out.println(System.lineSeparator());
        System.out.println(dog.run(400));
        System.out.println(dog.swim(25));
        System.out.println(dog.leap(3));

        Cat cat1 = new Cat();
        System.out.println(Cat.getCount()); //2
        System.out.println(Dog.getCount()); //1
    }
}
