package lesson1;

public class Wall extends Challenge {

    private int heigth;

    public Wall(String name, int heigth) {
        super(name);

        this.heigth = heigth;
    }

    public int getHeigth() {
        return heigth;
    }

    @Override
    protected boolean moving(Jumpruns jumpruns) {
        System.out.println( super.getName() + "высота: " + this.heigth + " м");

        jumpruns.jump();

        if (getHeigth() <= jumpruns.getJumpHeightLimit()) {


            return true;
        } else {


            return false;
        }
    }
}
