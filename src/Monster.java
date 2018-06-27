import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;

public class Monster extends GameObject {
    public Monster(int x, int y, String symbol, Terminal.Color color) {
        super(x, y, symbol, color);
    }

    public static Monster[] createMonsters(Level level) {
        List<Monster> monsters = new ArrayList<>();
        for (int x = 0; x < level.getLevelArray().length; x++) {
            for (int y = 0; y < level.getLevelArray()[x].length; y++) {
                if (level.getLevelArray()[x][y] == 2) {
                    monsters.add(new Monster(x, y, " ", Terminal.Color.RED));
                    level.getLevelArray()[x][y] = 0;
                }

            }

        }
        return (Monster[]) monsters.toArray();
    }
}
