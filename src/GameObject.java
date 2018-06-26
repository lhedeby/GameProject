import com.googlecode.lanterna.terminal.Terminal;

public abstract class GameObject {

    protected int x, y;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getSymbol() {
        return symbol;
    }

    public Terminal.Color getColor() {
        return color;
    }

}
