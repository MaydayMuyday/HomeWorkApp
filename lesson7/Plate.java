package lesson7;

public class Plate {
    private int food;

    int getFood() {
        return food;
    }

    Plate(int food) {
        this.food = food;
    }

    void decreaseFood(int n) {
        food -= n;
    }

    void increaseFood() {
        this.food += 300;
        System.out.println("В миску добавили корма: 300 грамм");
    }

    boolean checkFood(int n) {
        return (food - n) >= 0;
    }

}