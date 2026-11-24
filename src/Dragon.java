public class Dragon extends Character implements Jumpable {

    private boolean jumping;

    public Dragon(String name) {
        super(name);
        jumping = false;
    }

    @Override
    public void move() {
        x += 1;
    }

    @Override
    public void jump() {

        if (!jumping) {
            jumping = true;
        }
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
}
