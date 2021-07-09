package lesson7;

public class Main {


    public static void main(String[] args) {

        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Васька", 150);
        cat[1] = new Cat("Мурзик", 100);
        cat[2] = new Cat("Симба", 30);


        Plate plate = new Plate(0);


        for (int i = 0; i < cat.length; i++) {
            if (cat[i].getSatiety() == 0) {
                if (!plate.checkFood(cat[i].getAppetite())) {
                    plate.increaseFood();
                }
                cat[i].eat(plate);

                System.out.println("Кот " + cat[i].getName() + " съел " + cat[i].getAppetite() + " грамм корма");

                System.out.println("Корма осталось в миске: " + plate.getFood());
                System.out.println("Кот " + cat[i].getName() + ", состояние голода:  " + cat[i].getSatiety());
            }
        }


    }
}


