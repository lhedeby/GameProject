import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Monster extends GameObject {
    public Monster(int x, int y, String symbol, Terminal.Color color) {
        super(x, y, symbol, color);
        this.xVelocity = 1;
    }

    public static void updateMonstersList(Level level, List<Monster> monstersList) {
        monstersList.clear();;
        for (int x = 0; x < level.getLevelArray().length; x++) {
            for (int y = 0; y < level.getLevelArray()[x].length; y++) {
                if (level.getLevelArray()[x][y] == 2) {
                    monstersList.add(new Monster(x, y, " ", Terminal.Color.RED));
                    level.getLevelArray()[x][y] = 0;
                }
            }
        }
    }
}
