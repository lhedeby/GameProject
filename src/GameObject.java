import com.googlecode.lanterna.terminal.Terminal;

public abstract class GameObject {

    protected int x, y;
    protected String symbol;
    protected Terminal.Color color;
    protected int speed;

    public GameObject(int x, int y, String symbol, Terminal.Color color, int speed) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = color;
        this.speed = speed;
    }
}
