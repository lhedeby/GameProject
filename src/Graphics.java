import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;

import java.util.List;

public class Graphics {
    ScreenWriter screenWriter;
    Player player;
    Level level;
    Goal goal;
    List<Monster> monstersList;
    Window window;

    public Graphics(Window window, Player player, Level level, Goal goal, List<Monster> monstersList) {
        this.screenWriter = new ScreenWriter(window.getScreen());
        this.player = player;
        this.level = level;
        this.goal = goal;
        this.monstersList = monstersList;
        this.window = window;
    }
    public Graphics(Level level, Window window) {
        this.level = level;
        this.screenWriter = new ScreenWriter(window.getScreen());
        this.window = window;

    }

    public void draw(int x, int y, Color color, String symbol) {
        screenWriter.setBackgroundColor(color);
        screenWriter.drawString(x, y, symbol);
    }

    public void drawObject(int x, int y, Color color, String symbol){
        screenWriter.setForegroundColor(color);
        screenWriter.drawString(x, y, symbol, ScreenCharacterStyle.Bold);
    }


    public void drawLevelEditor() {
        Blocks[][] array = level.getLevelArray();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (array[x][y] == Blocks.GROUND)
                    draw(x, y, Color.GREEN, " ");
                if (array[x][y] == Blocks.SKY)
                    draw(x, y, Color.BLUE, " ");
                if (array[x][y] == Blocks.MONSTER)
                    draw(x, y, Color.RED, " ");
                if (array[x][y] == Blocks.GOAL)
                    draw(x, y, Color.YELLOW, " ");
                if(array[x][y] == Blocks.PLAYER)
                    draw(x, y, Color.WHITE, " ");
            }
        }
    }

    public void drawLevel() {
        Blocks[][] array = level.getLevelArray();
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[x].length; y++) {
                if (array[x][y] == Blocks.GROUND)
                    draw(x, y, Color.GREEN, " ");
                if (array[x][y] == Blocks.SKY)
                    draw(x, y, Color.BLUE, " ");
            }
        }
    }
    public void render() {
        drawLevel();
        drawPlayer();
        drawMonsters();
        drawGoal();
        window.getScreen().refresh();
    }

    public void drawGameObject(GameObject gameObject) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        Terminal.Color color = gameObject.getColor();
        String symbol = gameObject.getSymbol();

        drawObject(x, y, color, symbol);
    }

    public void drawMonsters() {
        for(Monster monster:monstersList){
            drawGameObject(monster);
        }
    }
    public void drawPlayer() { drawGameObject(player);}
    public void drawGoal(){
        drawGameObject(goal);
    }

    public void start() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "           Welcome!           ");
        screenWriter.drawString(35, 12, "       Press key to start     ");
        screenWriter.drawString(35, 13, "                              ");
        MP3Player.play(".\\src\\supergame.mp3");
        window.getScreen().refresh();

    }

    public void gameOver() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "          Game over!          ", ScreenCharacterStyle.Bold);
        screenWriter.drawString(35, 12, "     Press key to restart     ");
        screenWriter.drawString(35, 13, "                              ");
        MP3Player.stop(".\\src\\supergame.mp3");
        MP3Player.play(".\\src\\button-3.mp3");
        window.getScreen().refresh();

    }

    public void win() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "            You win!          ", ScreenCharacterStyle.Blinking);
        screenWriter.drawString(35, 12, "   Press key for next level   ");
        screenWriter.drawString(35, 13, "                              ");
        MP3Player.stop(".\\src\\supergame.mp3");
        MP3Player.play(".\\src\\victory.mp3");
        window.getScreen().refresh();

    }

    public void winGame() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "       You win the game!      ", ScreenCharacterStyle.Blinking);
        screenWriter.drawString(35, 12, "     Press key to restart     ");
        screenWriter.drawString(35, 13, "                              ");
        MP3Player.stop(".\\src\\supergame.mp3");
        MP3Player.play(".\\src\\victory.mp3");
        window.getScreen().refresh();

    }

}
