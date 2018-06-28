package supergame.game;

import supergame.game.gameobjects.Goal;
import supergame.game.gameobjects.Monster;
import supergame.game.gameobjects.Player;
import supergame.game.graphics.Graphics;
import supergame.game.graphics.Window;
import supergame.game.input.KeyManager;
import supergame.game.level.Level;
import supergame.game.logic.Logic;
import supergame.game.sound.MP3Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int MAXLEVELS = 6;
    private Window window;
    private Level level;
    private Player player;
    private KeyManager keyManager;
    private Logic logic;
    private List<Monster> monstersList;
    private Goal goal;
    private int levelCounter = 1;
    private boolean pause;
    private boolean start;


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
        pause = true;
        start = true;


    }

    private void newLevel() {
        level.loadLevel(levelCounter);
        player.setPlayerPosition(level);
        Monster.updateMonstersList(level, monstersList);
        goal.setGoalPosition(level);
        MP3Player.play(".\\res\\sound\\supergame.mp3", true);
    }

    public void loop() {
        while (true) {

            keyManager.keyDetector();
            logic.moveObjects();
            window.getGraphics().render();


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
        window.getGraphics().gameOver();
        start = true;
        levelCounter = 1;
        MP3Player.stop(".\\res\\sound\\supergame.mp3");
        MP3Player.play(".\\res\\sound\\button-3.mp3");
    }

    private void displayStartScreen() {
        window.getGraphics().start();
        start = false;
        pause = true;
    }

    private void displayWinScreen() {
        pause = true;
        levelCounter++;
        if (levelCounter == MAXLEVELS) {
            window.getGraphics().winGame();
            levelCounter = 1;
            start = true;
        } else {
            window.getGraphics().win();
        }
        MP3Player.stop(".\\res\\sound\\supergame.mp3");
        MP3Player.play(".\\res\\sound\\victory.mp3");
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
