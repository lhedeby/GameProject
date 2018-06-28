import com.googlecode.lanterna.input.Key;

import javax.swing.*;
import java.io.*;



public class Levelmaker {

    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        Window window = new Window();
        window.getScreen().setCursorPosition(x, y);
        window.getScreen().refresh();
        Level level = new Level(window);
        level.loadLevel(1);
        window.setGraphics(new Graphics(level, window));




        Key key;
        while (true) {
            window.graphics.drawLevelEditor();
            window.getScreen().refresh();
            do {
                key = window.getScreen().readInput();
            } while (key == null);
            switch (key.getKind()) {
                case F1:
                    level.levelArray[x][y] = Blocks.GROUND;
                    break;
                case F2:
                    level.levelArray[x][y] = Blocks.SKY;
                    break;
                case F3:
                    level.levelArray[x][y] = Blocks.MONSTER;
                    break;
                case F4:
                    level.levelArray[x][y] = Blocks.GOAL;
                    break;
                case F5:
                    level.levelArray[x][y] = Blocks.PLAYER;
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

    private static String intArrayToString(Blocks[] array) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            res.append(array[i].getValue());
        }
        return res.toString();
    }
}
