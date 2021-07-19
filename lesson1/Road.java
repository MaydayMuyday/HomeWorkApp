package lesson1;

public class Road extends Challenge {
    private int length;

    public Road(String name, int length) {
        super(name);

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    protected boolean moving(Jumpruns jumpruns) {
        System.out.println( super.getName() + " длина: " + this.length + " м");

        jumpruns.run();

        if (getLength() <= jumpruns.getRunDistanceLimit()) {


            return true;
        } else {


            return false;
        }
    }
}
