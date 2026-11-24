public class Tree extends Obstacle {

    public Tree(double x, double y) {
        super(x, y);
    }

    @Override
    public String getSymbol() {
        return "🌲";
    }

    @Override
    public double getSpeed() {
        return 5.5;
    }
}

