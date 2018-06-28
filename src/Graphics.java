import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

public class Graphics {
    ScreenWriter screenWriter;

    public Graphics(Window window) {
        screenWriter = new ScreenWriter(window.getScreen());


    }

    public void draw(int x, int y, Color color, String symbol) {
        screenWriter.setBackgroundColor(color);
        screenWriter.drawString(x, y, symbol);
    }

    public void drawLevel(Level level) {
        int[][] array = level.getLevelArray();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (array[x][y] == 1)
                    draw(x, y, Color.GREEN, " ");
                if (array[x][y] == 0)
                    draw(x, y, Color.BLUE, " ");
                if (array[x][y] == 2)
                    draw(x, y, Color.RED, " ");
                if (array[x][y] == 3)
                    draw(x, y, Color.YELLOW, " ");
                if(array[x][y] == 4)
                    draw(x, y, Color.WHITE, " ");
            }
        }
    }

    public void drawPlayer(GameObject gameObject) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        Terminal.Color color = gameObject.getColor();
        String symbol = gameObject.getSymbol();

        draw(x, y, color, symbol);
    }

    public void drawMonsters(Monster[] monsters) {
        for (int i = 0; i < monsters.length; i++) {
            drawPlayer(monsters[i]);
        }
    }

    public void drawGoal(Goal goal){
        drawPlayer(goal);
    }

    public void start() {
        screenWriter.drawString(30, 10, "                              ");
        screenWriter.drawString(30, 11, "           Welcome!           ");
        screenWriter.drawString(30, 12, "       Press key to start     ");
        screenWriter.drawString(30, 13, "                              ");
        MP3Player.stop(".\\src\\supergame.mp3");
        MP3Player.play(".\\src\\button-3.mp3");

    }

    public void gameOver() {
        screenWriter.drawString(30, 10, "                              ");
        screenWriter.drawString(30, 11, "          Game over!          ");
        screenWriter.drawString(30, 12, "     Press key to restart     ");
        screenWriter.drawString(30, 13, "                              ");
        MP3Player.stop(".\\src\\supergame.mp3");
        MP3Player.play(".\\src\\button-3.mp3");

    }

    public void win() {
        screenWriter.drawString(30, 10, "                              ");
        screenWriter.drawString(30, 11, "            You win!          ");
        screenWriter.drawString(30, 12, "   Press key for next level   ");
        screenWriter.drawString(30, 13, "                              ");
        MP3Player.stop(".\\src\\supergame.mp3");
        MP3Player.play(".\\src\\victory.mp3");
        MP3Player.play(".\\src\\supergame.mp3");

    }

}
