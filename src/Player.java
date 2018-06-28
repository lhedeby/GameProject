
import com.googlecode.lanterna.terminal.Terminal;

import static com.googlecode.lanterna.terminal.Terminal.*;

public class Player extends GameObject {

    public Player() {
        super(0, 0, "P", Color.WHITE);
    }

    public void setPlayerPosition(Level level){
        for (int x = 0; x < level.getLevelArray().length; x++) {
            for (int y = 0; y < level.getLevelArray()[x].length; y++) {
                if (level.getLevelArray()[x][y] == 4) {
                    this.setX(x);
                    this.setY(y);
                    level.getLevelArray()[x][y] = 0;
                }
            }
        }
    }
}
