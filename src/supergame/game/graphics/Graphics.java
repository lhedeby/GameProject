package supergame.game.graphics;

import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import supergame.game.gameobjects.*;
import supergame.game.level.Level;

import java.util.List;

public class Graphics {
    private ScreenWriter screenWriter;
    private Player player;
    private Level level;
    private Goal goal;
    private List<Monster> monstersList;
    private Window window;

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

    private void draw(int x, int y, Color color, String symbol) {
        screenWriter.setBackgroundColor(color);
        screenWriter.drawString(x, y, symbol);
    }

    private void drawObject(int x, int y, Color color, String symbol){
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

    private void drawLevel() {
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

    private void drawGameObject(GameObject gameObject) {
        int x = gameObject.getX();
        int y = gameObject.getY();
        Terminal.Color color = gameObject.getColor();
        String symbol = gameObject.getSymbol();

        drawObject(x, y, color, symbol);
    }

    private void drawMonsters() {
        for(Monster monster:monstersList){
            drawGameObject(monster);
        }
    }
    private void drawPlayer() { drawGameObject(player);}
    private void drawGoal(){
        drawGameObject(goal);
    }

    public void start() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "          Super  Game         ");
        screenWriter.drawString(35, 12, "                              ");
        screenWriter.drawString(35, 13, "     Press ENTER to start     ");
        screenWriter.drawString(35, 14, "                              ");
        window.getScreen().refresh();

    }

    public void gameOver() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "          Game over!          ", ScreenCharacterStyle.Blinking);
        screenWriter.drawString(35, 12, "    Press ENTER to restart    ");
        screenWriter.drawString(35, 13, "                              ");
        window.getScreen().refresh();

    }

    public void win() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "            You win!          ", ScreenCharacterStyle.Blinking);
        screenWriter.drawString(35, 12, "   Press ENTER for next level  ");
        screenWriter.drawString(35, 13, "                              ");
        window.getScreen().refresh();

    }

    public void winGame() {
        screenWriter.setBackgroundColor(Color.YELLOW);
        screenWriter.setForegroundColor(Color.WHITE);
        screenWriter.drawString(35, 10, "                              ");
        screenWriter.drawString(35, 11, "       You win the game!      ", ScreenCharacterStyle.Blinking);
        screenWriter.drawString(35, 12, "    Press ENTER to restart    ");
        screenWriter.drawString(35, 13, "                              ");
        window.getScreen().refresh();

    }

}
