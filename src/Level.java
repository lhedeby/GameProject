public class Level {
    int[][] levelArray;
    public Level(Window window) {
        levelArray = new int[window.getWidth()][window.getHeight()];
        for(int i = 0; i < window.getWidth(); i++) {
            levelArray[i][20] = 1;
        }
    }

    public int[][] getLevelArray() {
        return levelArray;
    }

}
