public abstract class Character {

    protected String name;
    protected double x;
    protected double y;

    public Character(String name) {
        this.name = name;
        this.x = 0;
        this.y = 0;
    }

    public String getName() {
        return name;
    }

    public abstract void move();
}
