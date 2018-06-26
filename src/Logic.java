public class Logic {
    Player player;
    Level level;

    public Logic(Player player, Level level) {
        this.level = level;
        this.player = player;
    }

    public void movePlayer() {
        if (level.getLevelArray()[player.x + player.xVelocity][player.y] != 1) {
            this.player.x = player.x + player.xVelocity;

        }
    }
}
