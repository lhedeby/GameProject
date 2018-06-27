import com.googlecode.lanterna.input.Key;

import javax.swing.*;
import java.io.*;

import static com.googlecode.lanterna.input.Key.Kind.*;

public class Levelmaker {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        Window window = new Window();
        window.getScreen().setCursorPosition(x, y);
        window.getScreen().refresh();
        Level level = new Level(window);


        Key key;
        while (true) {
            window.graphics.drawLevel(level);
            window.getScreen().refresh();
            do {
                key = window.getScreen().readInput();
            } while (key == null);
            switch (key.getKind()) {
                case F1:
                    level.levelArray[x][y] = 1;
                    break;
                case F2:
                    level.levelArray[x][y] = 0;
                    break;
                case F3:
                    level.levelArray[x][y] = 2;
                    break;
                case F4:
                    level.levelArray[x][y] = 3;
                    break;
                case ArrowDown:
                    window.getScreen().setCursorPosition(x, ++y);
                    break;
                case ArrowUp:
                    window.getScreen().setCursorPosition(x, --y);
                    break;
                case ArrowLeft:
                    window.getScreen().setCursorPosition(--x, y);
                    break;
                case ArrowRight:
                    window.getScreen().setCursorPosition(++x, y);
                    break;
                case Escape:
                    writeToFile(level);
                    System.exit(0);
            }

        }


    }

    public static void writeToFile(Level level) {

        try {
            String path = JOptionPane.showInputDialog("Please write filename: ");
            PrintWriter writer = new PrintWriter(".\\Levels\\" + path , "UTF-8");
            for(int i = 0; i < level.levelArray.length; i++) {
                writer.println(intArrayToString(level.levelArray[i]));
            }
            writer.close();


        } catch (Exception e1) {
            System.out.println("Error writing to file");
        }

    }

    private static String intArrayToString(int[] array) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            res.append(array[i]);
        }
        return res.toString();
    }
}
