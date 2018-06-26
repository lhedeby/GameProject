import com.googlecode.lanterna.terminal.Terminal;

public class Game {
    Window window;
    Level level;
    public void init() {
        window = new Window();
        level = new Level(window);

    }

    public void loop() {
//        for(int i = 0; i < window.getScreen().getTerminal().getTerminalSize().getColumns(); i++) {
//            window.graphics.draw(i , 20, Terminal.Color.GREEN);
//        }
        window.graphics.drawLevel(level);
        window.getScreen().refresh();
    }
}
