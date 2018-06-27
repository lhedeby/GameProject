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
    }



    public void loadLevel(int counter) {
        StringBuilder sb = new StringBuilder(".\\Levels\\level" + counter);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sb.toString()));
            int line = 0;
            while(true) {
                String s = reader.readLine();
                if (s == null)
                    break;

                for(int i = 0; i < s.length(); i++) {
                    levelArray[line][i] = Integer.parseInt(s.charAt(i) + "");
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
