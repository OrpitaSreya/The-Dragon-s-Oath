public class Fire extends Obstacle {

    public Fire(double x, double y) {
        super(x, y);
    }

    @Override
    public String getSymbol() {
        return "🔥";
    }

    @Override
    public double getSpeed() {
        return 6;
    }
}
