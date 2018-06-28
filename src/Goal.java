import com.googlecode.lanterna.terminal.Terminal;

public class Goal extends GameObject {

    public Goal() {
        super(0, 0, "\u2348", Terminal.Color.YELLOW);
    }

     public void setGoalPosition(Level level){
        for (int x = 0; x < level.getLevelArray().length; x++) {
            for (int y = 0; y < level.getLevelArray()[x].length; y++) {
                if (level.getLevelArray()[x][y] == 3) {
                    this.setX(x);
                    this.setY(y);
                }
            }
        }
    }
}
