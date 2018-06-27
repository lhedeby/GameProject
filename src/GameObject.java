import com.googlecode.lanterna.terminal.Terminal;

public abstract class GameObject {

    private int x, y;
    protected String symbol;
    protected Terminal.Color color;
    protected int yVelocity;
    protected int xVelocity;

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public GameObject(int x, int y, String symbol, Terminal.Color color) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = color;
        this.xVelocity = 0;
        this.yVelocity = 1;
    }

    protected int getX() {
        return x;
    }

    protected int getY() {
        return y;
    }

    protected void setX(int x) {
        this.x = x;
    }

    protected void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        return symbol;
    }

    public Terminal.Color getColor() {
        return color;
    }

}
