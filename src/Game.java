import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int MAXLEVELS = 6;
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
        MP3Player.play(".\\src\\supergame.mp3", true);
    }

    public void loop() {
        while (true) {

            keyManager.keyDetector();
            logic.moveObjects();
            window.graphics.render();


            if (start)
                displayStartScreen();

            if (!logic.isAlive() || !logic.isNotFallen())
                displayDeathScreen();

            if (logic.isWin())
                displayWinScreen();

            while (pause)
                pauseGame();

            sleep();
        }
    }

    private void displayDeathScreen() {
        pause = true;
        window.graphics.gameOver();
        start = true;
        levelCounter = 1;

    }

    private void displayStartScreen() {
        window.graphics.start();
        start = false;
        pause = true;
    }

    private void displayWinScreen() {
        pause = true;
        levelCounter++;
        if (levelCounter == MAXLEVELS) {
            window.graphics.winGame();
            levelCounter = 1;
            start = true;
        } else {
            window.graphics.win();
        }
    }

    private void pauseGame() {
        if (!keyManager.keyDetectorPause()) {
            pause = false;

        }
        newLevel();
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
