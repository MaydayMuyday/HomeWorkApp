package lesson6;

import lesson6.animals.*;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        Dog dog = new Dog("Bobik");

        System.out.println(cat);
        System.out.println(dog);
        cat.animalRun(250);
        cat.animalSwim(50);
        dog.animalRun(400);
        dog.animalSwim(10);
        System.out.println("Животных создано " + Animal.animalCount());

    }
}
