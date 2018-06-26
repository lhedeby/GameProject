import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenCharacterStyle;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Window {

    Graphics graphics;
    Screen screen;

    public Window() {
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        screen = new Screen(terminal);
        screen.startScreen();

        graphics = new Graphics(this);
    }

    public Screen getScreen() {
        return screen;
    }
}
