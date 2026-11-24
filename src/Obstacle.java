public abstract class Obstacle {

    protected double x;
    protected double y;

    public Obstacle(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract String getSymbol();

    public abstract double getSpeed();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move() {
        x -= getSpeed();
    }
}