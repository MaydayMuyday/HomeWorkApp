package lesson1;

public class Robot implements Jumpruns {
    private String name;
    private int runDistance;
    private int jumpHeight;

    public Robot(String name, int distance, int jumpHeight) {
        this.name = name;
        this.runDistance = distance;
        this.jumpHeight = jumpHeight;
    }

    @Override
    public void run() {
        System.out.println("Робот " + this.name + " может пробежать " + this.getRunDistanceLimit()+ " м" );
    }

    @Override
    public void jump() {
        System.out.println("Робот  " + this.name + " может прыгнуть на " + this.getJumpHeightLimit()+ " м");
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
