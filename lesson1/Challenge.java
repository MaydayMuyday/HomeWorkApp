package lesson1;

public abstract class Challenge {
    private String name;

    public Challenge(String name) {
        this.name = name;
    }

    protected abstract boolean moving(Jumpruns jumpruns);

    public String getName() {
        return name;
    }
}
