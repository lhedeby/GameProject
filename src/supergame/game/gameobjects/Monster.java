package supergame.game.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;
import supergame.game.level.Level;

import java.util.List;

public class Monster extends GameObject {
    public Monster(int x, int y, String symbol, Terminal.Color color) {
        super(x, y, symbol, color);
        this.setxVelocity(1);
    }

    public static void updateMonstersList(Level level, List<Monster> monstersList) {
        monstersList.clear();
        for (int x = 0; x < level.getLevelArray().length; x++) {
            for (int y = 0; y < level.getLevelArray()[x].length; y++) {
                if (level.getLevelArray()[x][y] == Blocks.MONSTER) {
                    monstersList.add(new Monster(x, y, "\u2620", Terminal.Color.RED));
                    level.getLevelArray()[x][y] = Blocks.SKY;
                }
            }
        }
    }
}
