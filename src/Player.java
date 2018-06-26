
import static com.googlecode.lanterna.terminal.Terminal.*;

public class Player extends GameObject {
    public static final int LEFT = -1;
    public static final int RIGHT = 1;
    public static final int UP = -1;
    public static final int DOWN = 1;


    public Player(int x, int y) {
        super(x,y,  "P", Color.WHITE, 3);
    }

    public void movePlayer(int x){
        this.x += x;
    }
}
