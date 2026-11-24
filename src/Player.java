public class Player {

    private String name;
    private int score;
    private boolean eggFound;

    public Player(String name) {
        this.name = name;
        score = 0;
        eggFound = false;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public boolean hasEgg() {
        return eggFound;
    }

    public void addScore() {
        score++;
    }

    public void addScore(int points) {
        score += points;
    }

    public void findEgg() {
        eggFound = true;
    }
}