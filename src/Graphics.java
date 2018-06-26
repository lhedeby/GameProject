import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal.Color;

public class Graphics {
    ScreenWriter screenWriter;
    public Graphics(Window window) {
          screenWriter = new ScreenWriter(window.getScreen());

    }

    public void drawString() {

    }

    public void draw(int x, int y, Color color) {
        screenWriter.setBackgroundColor(color);
        screenWriter.drawString(x, y, " ");
    }

    public void drawLevel(Level level) {
        int[][] array = level.getLevelArray();
        for(int x = 0; x < array.length; x++) {
            for(int y = 0; y < array[x].length; y++) {
                if(array[x][y] == 1)
                    draw(x, y, Color.BLUE);
            }
        }
    }


}
