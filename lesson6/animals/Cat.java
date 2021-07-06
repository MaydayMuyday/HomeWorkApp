package lesson6.animals;

public class Cat extends Animal {
    private int maxRunDist = 200;
    private int maxSwimDist = 0;

    public Cat(String name) {

        super(name);
    }


    @Override
    public void animalRun(int run) {
        if (run <= maxRunDist || run > 0) {
            System.out.println(name + "пробежал " + run + "метров ");
        } else {
            System.out.println(name + " кот, и он столько не может пробежать. отдохнет, побежит дальше:)");
        }
    }


    public void animalSwim(int swim) {
        if (swim != maxSwimDist) {
            System.out.println(name + " кот, и он не может проплысть " + swim + " метров. Коты совсем не любят плавать. ");
        }
    }

    @Override
    public String toString() {
        return "Кот, по имени " + name;

    }


}


