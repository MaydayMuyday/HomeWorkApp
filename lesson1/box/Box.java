package lesson1.box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class Box<T extends Fruit> {
    public static void main(String[] args) {


        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox = new Box<>();
        Box<Fruit> fruitBox = new Box<>();
        orangeBox.add(new Orange(orangeBox.getWeight()), 10);
        appleBox.add(new Apple(appleBox.getWeight()), 15);
        fruitBox.add(new Orange(orangeBox.getWeight()), 1);
        fruitBox.add(new Apple(appleBox.getWeight()), 3);
        System.out.println("Коробка Апельсинов: " + orangeBox.getWeight());
        System.out.println("Коробка яблок: " + appleBox.getWeight());
        System.out.println("Универсальная коробка: " + fruitBox.getWeight());
        System.out.println("orangeBox equals appleBox : " + orangeBox.compare(appleBox));

    }

    private ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public Box(T... fruits) {
        this.list = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;

        for (T o : list) {
            weight += o.getWeight();
        }
        return weight;
    }

    public void pour(Box<T> another) {
        another.list.addAll(list);
        list.clear();
    }

    public void add(T fruit, int i) {
        list.add(fruit);
    }

    public void add(Collection<T> fruit) {
        list.addAll(fruit);
    }

    public boolean compare(Box<?> o) {


        return Math.abs(this.getWeight() - o.getWeight()) < 0.001;
    }
}