import com.googlecode.lanterna.terminal.Terminal;

public class Game {
    Window window;
    Level level;
    GameObject player;
    KeyManager keyManager;

    public void init() {
        window = new Window();
        level = new Level(window);
        player = new Player(10,19);
        keyManager = new KeyManager((Player)player, window.getScreen());

    }

    public void loop() {
        while (true) {
            window.graphics.drawLevel(level);
            window.graphics.drawPlayer(player);
            window.getScreen().refresh();
            keyManager.keyDetector();
            window.getScreen().clear();

        }
    }
}
