package lesson6.animals;

public class Dog extends Animal {
    private int maxRunDist = 500;
    private int maxSwimDist = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void animalRun(int run) {
        if (run <= maxRunDist || run > 0) {
            System.out.println(name + " пробежал " + run + " метров ");
        } else {
            System.out.println(name + " не может столько пробежать");
        }
    }


    @Override
    public void animalSwim(int swim) {
        if (swim <= maxSwimDist || swim > 0) {
            System.out.println(name + " проплыл " + swim + " метров ");
        } else {
            System.out.println(name + " столько не может проплыть");
        }
    }

    @Override
    public String toString() {
        return "Пёс, по имени " + name;

    }
}