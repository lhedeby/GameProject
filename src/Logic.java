public class Logic {
    Player player;
    Level level;
    int jumpCounter;
    boolean canJump = true;

    public Logic(Player player, Level level) {
        this.level = level;
        this.player = player;
    }

    public void movePlayer() {
        if (level.getLevelArray()[player.getX() + player.xVelocity][player.getY()] != 1) {
            this.player.setX(player.getX() + player.xVelocity);
        }

        if(player.yVelocity<0 && canJump){
            if(jumpCounter<5){
                if (level.getLevelArray()[player.getX()][player.getY() - 1] != 1) {
                    this.player.setY(player.getY() - 1);
                }
                jumpCounter++;
            } else {
                jumpCounter = 0;
                player.setyVelocity(1);
                canJump = false;

            }
        } else {
            if (level.getLevelArray()[player.getX()][player.getY() + 1] != 1) {
                this.player.setY(player.getY() + 1);
                canJump = false;
            } else {
                canJump = true;
            }
        }

    }
}
