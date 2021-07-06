package lesson6.animals;

public class Animal {

    static String name;
    static int count;


    public Animal(String name) {
        this.name = name;
        Animal.count++;


    }

    public void animalRun(int run) {
        System.out.println(name + "пробежал " + run + " метров ");
    }

    public void animalSwim(int swim) {
        System.out.println(name + "проплыл " + swim + " метров ");

    }


    public static int animalCount() {
        return Animal.count;
    }


}

