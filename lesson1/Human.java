package lesson1;

public class Human implements Jumpruns {
    private String name;
    private int runDistanceLimit;
    private int jumpHeightLimit;

    public Human(String name, int distance, int jumpHeightLimit) {
        this.name = name;
        this.runDistanceLimit = distance;
        this.jumpHeightLimit = jumpHeightLimit;
    }

    @Override
    public void jump() {
        System.out.println("человек " + this.name + " может прыгнуть на  " + this.getJumpHeightLimit() + " м");
    }

    @Override
    public void run() {
        System.out.println("человек " + this.name + " может пробежать " + this.getRunDistanceLimit() + " м" );
    }

    @Override
    public int getRunDistanceLimit() {
        return this.runDistanceLimit;
    }

    @Override
    public int getJumpHeightLimit() {
        return this.jumpHeightLimit;
    }

}
