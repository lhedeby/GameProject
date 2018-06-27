public class Level {
    int[][] levelArray;
    public Level(Window window) {
        levelArray = new int[window.getWidth()][window.getHeight()];
        for(int i = 0; i < window.getWidth(); i++) {
            levelArray[i][20] = 1;
        }
        levelArray[35][19] = 1;
        for (int i = 15; i < 18; i++) {
            levelArray[i][20] = 0;
        }

    }

    public int[][] getLevelArray() {
        return levelArray;
    }

}
