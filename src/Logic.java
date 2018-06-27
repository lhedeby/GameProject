public class Logic {
    Player player;
    Level level;

    public Logic(Player player, Level level) {
        this.level = level;
        this.player = player;
    }

    public void movePlayer() {
        if (level.getLevelArray()[player.getX() + player.xVelocity][player.getY()] != 1) {
            this.player.setX(player.getX() + player.xVelocity);

        }
    }
}
