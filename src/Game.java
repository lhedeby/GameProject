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
    int levelCounter = 1;
    boolean pause;
    boolean start;


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
        pause = true;
        start = true;


    }

    public void newLevel() {
        level.loadLevel(levelCounter);
        player.setPlayerPosition(level);
        Monster.updateMonstersList(level, monstersList);
        goal.setGoalPosition(level);
    }

    public void loop() {
        while (true) {

            window.graphics.render();
            keyManager.keyDetector();
            logic.movePlayer();
            logic.moveMonsters();
            if (!logic.isAlive()) {
                pause = true;
                window.graphics.gameOver();
                break;
            }
            if (start == true) {
                window.graphics.start();
                start = false;
            }
            if (logic.isWin()) {
                pause = true;
                levelCounter++;
                if (levelCounter == 4) {
                    window.graphics.winGame();
                    levelCounter = 1;
                    start = true;
                } else {
                    window.graphics.win();
                }
            }
            while (pause) {
                pauseGame();
            }
            sleep();
        }
    }
    public void pauseGame() {
        if (!keyManager.keyDetectorPause()) {
            pause = false;
        }
        newLevel();
    }
    public void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
