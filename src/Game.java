public class Game {
    Window window;
    Level level;
    GameObject player;
    KeyManager keyManager;
    Logic logic;
    Monster[] monstersArray;
    Goal goal;
    int counter = 1;
    boolean pause;


    public void init() {
        window = new Window();
        level = new Level(window);
        level.loadLevel(counter);
        player = new Player(1, 19);
        monstersArray = Monster.createMonsters(level);
        goal = Goal.createGoal(level);
        keyManager = new KeyManager((Player) player, window.getScreen());
        logic = new Logic((Player) player, level, monstersArray, goal);
        MP3Player.play(".\\src\\supergame.mp3", true);
        pause = false;


    }

    public void loop() {
        while (true) {
            window.graphics.drawLevel(level);
            window.graphics.drawPlayer(player);
            window.graphics.drawMonsters(monstersArray);
            window.graphics.drawGoal(goal);
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


                level.loadLevel(++counter);
                monstersArray = Monster.createMonsters(level);
                logic.monsters = monstersArray;
            }
            while (pause) {
                player.setX(1);
                player.setY(19);
                if (!keyManager.keyDetectorPause())
                pause = false;
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
