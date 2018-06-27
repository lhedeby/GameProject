import com.googlecode.lanterna.terminal.Terminal;

public class Goal extends GameObject {

    public Goal(int x, int y, String symbol, Terminal.Color color) {
        super(x, y, symbol, color);
    }

     public static Goal createGoal(Level level){
        for (int x = 0; x < level.getLevelArray().length; x++) {
            for (int y = 0; y < level.getLevelArray()[x].length; y++) {
                if (level.getLevelArray()[x][y] == 3) {
                    return new Goal(x,y," ", Terminal.Color.YELLOW);
                }
            }
        }
        return null;
    }
}
