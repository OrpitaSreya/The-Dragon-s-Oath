public class Rock extends Obstacle {

    public Rock(double x, double y) {
        super(x, y);
    }

    @Override
    public String getSymbol() {
        return "🪨";
    }

    @Override
    public double getSpeed() {
        return 5;
    }
}