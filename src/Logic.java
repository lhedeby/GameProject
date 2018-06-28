import java.util.List;

public class Logic {
    public static final int JUMPHEIGHT = 5;
    Player player;
    List<Monster> monstersList;
    Level level;
    Goal goal;
    int jumpCounter;
    int yNextStep;
    int xNextStep;
    boolean canJump = true;

    public Logic(Player player, Level level, List<Monster> monstersList, Goal goal) {
        this.level = level;
        this.player = player;
        this.monstersList = monstersList;
        this.goal = goal;
    }
    public void moveObjects() {
        moveMonsters();
        movePlayer();
    }
    public void movePlayer() {
        movePlayerX();
        movePlayerY();
    }
    private void movePlayerY() {
        if (player.yVelocity < 0 && canJump) {
            playerJump();
        } else {
           playerFall();
        }
    }

    private void movePlayerX() {
        checkBoundariesX();

        //check if square is solid
        if (level.getLevelArray()[xNextStep][player.getY()] != 1) {
            this.player.setX(xNextStep);
        }
        player.xVelocity = 0;
    }
    private void playerFall() {
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
    private void playerJump() {
        if (player.getY() - 1 > 0) {
            yNextStep = player.getY() - 1;
        } else {
            yNextStep = 0;
        }
        if (jumpCounter < JUMPHEIGHT) {

            if (level.getLevelArray()[player.getX()][yNextStep] != 1) {
                this.player.setY(yNextStep);
            }
            jumpCounter++;
        } else {
            jumpCounter = 0;
            player.setyVelocity(1);
            canJump = false;
        }
    }
    private void checkBoundariesX() {
        if (player.xVelocity < 0) {
            if (player.getX() + player.xVelocity < 0) {
                xNextStep = 0;
            } else {
                xNextStep = player.getX() + player.xVelocity;
            }
        } else {
            if (player.getX() + player.xVelocity >= level.getLevelArray().length) {
                xNextStep = level.getLevelArray().length - 1;
            } else {
                xNextStep = player.getX() + player.xVelocity;
            }
        }
    }

    private void moveMonster(Monster monster) {
        if (monster.xVelocity < 0) {
            if (monster.getX() + monster.xVelocity < 0) {
                xNextStep = 0;
            } else {
                xNextStep = monster.getX() + monster.xVelocity;
            }
        } else {
            if (monster.getX() + monster.xVelocity >= level.getLevelArray().length) {
                xNextStep = level.getLevelArray().length - 1;
            } else {
                xNextStep = monster.getX() + monster.xVelocity;
            }
        }
        if (level.getLevelArray()[xNextStep][monster.getY()] != 1) {
            monster.setX(xNextStep);
        } else {
            monster.xVelocity *= -1;
        }
    }

    public void moveMonsters() {
        for (Monster monster : monstersList) {
            moveMonster(monster);

        }
    }


    public boolean isAlive() {
        for(Monster monster:monstersList){
            if (collision(monster,player)) {
                return false;
            }
        }
        return true;
    }

    public boolean isNotFallen(){
        if(yNextStep == level.getLevelArray()[0].length - 1){
            return false;
        }
        return true;
    }

    public boolean isWin(){
        if(collision(goal,player)){
            return true;
        }
        return false;
    }

    private boolean collision(GameObject obj1, GameObject obj2){
        if (obj1.getX() == obj2.getX() && obj1.getY() == obj2.getY()) {
            return true;
        }
        return false;
    }
}
