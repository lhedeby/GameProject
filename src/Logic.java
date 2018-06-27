public class Logic {
    Player player;
    Level level;
    int jumpCounter;
    int yNextStep;
    int xNextStep;
    boolean canJump = true;

    public Logic(Player player, Level level) {
        this.level = level;
        this.player = player;
    }

    public void movePlayer() {
        if (player.xVelocity < 0){
            if(player.getX() + player.xVelocity < 0){
                xNextStep = 0;
            } else {
                xNextStep = player.getX() + player.xVelocity;
            }
        } else {
            if(player.getX() + player.xVelocity >= level.getLevelArray().length){
                xNextStep = level.getLevelArray().length -1;
            } else {
                xNextStep = player.getX() + player.xVelocity;
            }
        }
        if (level.getLevelArray()[xNextStep][player.getY()] != 1) {
            this.player.setX(xNextStep);
        }

        if (player.yVelocity < 0 && canJump) {
            if (player.getY() - 1 > 0) {
                yNextStep = player.getY() - 1;
            } else {
                yNextStep = 0;
            }
            if (jumpCounter < 5) {

                if (level.getLevelArray()[player.getX()][yNextStep] != 1) {
                    this.player.setY(yNextStep);
                }
                jumpCounter++;
            } else {
                jumpCounter = 0;
                player.setyVelocity(1);
                canJump = false;
            }
        } else {

            if (player.getY() + 1 >= level.getLevelArray()[0].length) {
                yNextStep = level.getLevelArray()[0].length - 1;
            } else {
                yNextStep = player.getY() + 1;
            }
            if (level.getLevelArray()[player.getX()][yNextStep] != 1) {
                this.player.setY(yNextStep);
                canJump = false;
            } else {
                canJump = true;
            }

        }

    }
}
