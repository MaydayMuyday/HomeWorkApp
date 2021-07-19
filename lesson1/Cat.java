package lesson1;

public class Cat implements Jumpruns {
    private String name;
    private int runDistance;
    private int jumpHeight;

    public Cat(String name, int distance, int jumpHeight) {
        this.name = name;
        this.runDistance = distance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run() {
        System.out.println("Кот " + this.name + " может пробежать " + this.getRunDistanceLimit() + " м");
    }

    @Override
    public void jump() {
        System.out.println("Кот " + this.name + " может прыгнуть на " + this.getJumpHeightLimit() + " м");
    }

    @Override
    public int getRunDistanceLimit() {
        return this.runDistance;
    }

    @Override
    public int getJumpHeightLimit() {
        return this.jumpHeight;
    }
}
