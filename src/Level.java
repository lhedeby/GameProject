import java.io.BufferedReader;
import java.io.FileReader;

public class Level {
    Blocks[][] levelArray;

    public Level(Window window) {
        levelArray = new Blocks[window.getWidth()][window.getHeight()];
        for(int i = 0; i < levelArray.length; i++) {
            for(int j = 0; j < levelArray[i].length; j++) {
                levelArray[i][j] = Blocks.GROUND;
            }
        }
    }



    public void loadLevel(int counter) {
        StringBuilder sb = new StringBuilder(".\\res\\Levels\\level" + counter);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sb.toString()));
            int line = 0;
            while(true) {
                String s = reader.readLine();
                if (s == null)
                    break;

                for(int i = 0; i < s.length(); i++) {
                    int blockType = Integer.parseInt(s.charAt(i) + "");
                    Blocks block = null;
                    switch (blockType) {
                        case 0:
                            block = Blocks.SKY;
                            break;
                        case 1:
                            block = Blocks.GROUND;
                            break;
                        case 2:
                            block = Blocks.MONSTER;
                            break;
                        case 3:
                            block = Blocks.GOAL;
                                    break;
                        case 4:
                            block = Blocks.PLAYER;
                            break;
                    }
                    levelArray[line][i] = block;
                }
                line++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Blocks[][] getLevelArray() {
        return levelArray;
    }

}
