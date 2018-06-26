import com.googlecode.lanterna.terminal.Terminal;

public class Game {
    Window window;
    Level level;

    public void init() {
        window = new Window();
        level = new Level(window);

    }

    public void loop() {
        while (true) {
            window.graphics.drawLevel(level);
            window.getScreen().refresh();
        }
    }
}
