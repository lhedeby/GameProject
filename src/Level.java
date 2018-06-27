import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Level {
    int[][] levelArray;
    public Level(Window window) {
        levelArray = new int[window.getWidth()][window.getHeight()];
        for(int i = 0; i < levelArray.length; i++) {
            for(int j = 0; j < levelArray[i].length; j++) {
                levelArray[i][j] = 0;
            }
        }
        loadLevel(levelArray);

    }

    public void loadLevel(int[][] array) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(".\\Levels\\level1"));
            int line = 0;
            while(true) {
                String s = reader.readLine();
                if (s == null)
                    break;

                for(int i = 0; i < s.length(); i++) {
                    array[line][i] = Integer.parseInt(s.charAt(i) + "");
                }
                line++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[][] getLevelArray() {
        return levelArray;
    }

}
