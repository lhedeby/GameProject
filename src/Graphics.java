import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;

public class Graphics {
    ScreenWriter screenWriter;
    public Graphics(Window window) {
          screenWriter = new ScreenWriter(window.getScreen());

    }

    public void drawString() {

    }
    
    public void draw(int x, int y) {
        screenWriter.setBackgroundColor();
    }
}
