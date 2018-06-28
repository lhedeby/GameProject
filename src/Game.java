import java.util.ArrayList;
import java.util.List;

public class Game {
    Window window;
    Level level;
    Player player;
    KeyManager keyManager;
    Logic logic;
    List<Monster> monstersList;
    Goal goal;
    int counter = 1;
    boolean pause;


    public void init() {
        window = new Window();
        player = new Player();
        level = new Level(window);
        goal = new Goal();
        monstersList = new ArrayList<>();
        window.setGraphics(new Graphics(window, player, level, goal, monstersList));
        newLevel();
        keyManager = new KeyManager(player, window.getScreen());
        logic = new Logic(player, level, monstersList, goal);
        MP3Player.play(".\\src\\supergame.mp3", true);
        pause = false;


    }

    public void newLevel() {
        level.loadLevel(counter);
        player.setPlayerPosition(level);
        Monster.updateMonstersList(level, monstersList);
        goal.setGoalPosition(level);
    }

    public void loop() {
        while (true) {
            window.graphics.render();
            window.getScreen().refresh();
            keyManager.keyDetector();
            logic.movePlayer();
            logic.moveMonsters();
            if (!logic.isAlive()) {
                pause = true;
                window.graphics.gameOver();
                window.getScreen().refresh();
                break;
            }
            if (logic.isWin()) {
                pause = true;
                window.graphics.win();
                window.getScreen().refresh();
                counter++;
            }
            while (pause) {
                if (!keyManager.keyDetectorPause())
                    pause = false;
                newLevel();
            }
            window.getScreen().clear();

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                continue;
            }
        }
    }
}
