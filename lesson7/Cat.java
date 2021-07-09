package lesson7;


public class Cat {
    private String name;
    private int appetite;

    private int satiety;


    Cat(String name, int appetite) {

        this.name = name;
        this.appetite = appetite;
        this.satiety = 0;
    }


    String getName() {

        return name;
    }

    int getAppetite() {

        return appetite;
    }


    int getSatiety() {
        return satiety;
    }

    void setSatiety(int satiety) {
        this.satiety = satiety;
    }


    void eat(Plate p) {
        p.decreaseFood(appetite);

    }
}