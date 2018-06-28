package supergame.game.logic;

import supergame.game.gameobjects.*;
import supergame.game.level.Level;

import java.util.List;

public class Logic {
    private static final int JUMPHEIGHT = 5;
    private Player player;
    private List<Monster> monstersList;
    private Level level;
    private Goal goal;
    private int jumpCounter;
    private int yNextStep;
    private int xNextStep;
    private boolean canJump = true;

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
    private void movePlayer() {
        movePlayerX();
        movePlayerY();
    }
    private void movePlayerY() {
        if (player.getyVelocity() < 0 && canJump) {
            playerJump();
        } else {
           playerFall();
        }
    }

    private void movePlayerX() {
        checkBoundariesX();

        //check if square is solid
        if (level.getLevelArray()[xNextStep][player.getY()] != Blocks.GROUND) {
            this.player.setX(xNextStep);
        }
        player.setxVelocity(0);
    }
    private void playerFall() {
        if (player.getY() + 1 >= level.getLevelArray()[0].length) {
            yNextStep = level.getLevelArray()[0].length - 1;
        } else {
            yNextStep = player.getY() + 1;
        }

        if (level.getLevelArray()[player.getX()][yNextStep] != Blocks.GROUND) {
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

            if (level.getLevelArray()[player.getX()][yNextStep] != Blocks.GROUND) {
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
        if (player.getxVelocity() < 0) {
            if (player.getX() + player.getxVelocity() < 0) {
                xNextStep = 0;
            } else {
                xNextStep = player.getX() + player.getxVelocity();
            }
        } else {
            if (player.getX() + player.getxVelocity() >= level.getLevelArray().length) {
                xNextStep = level.getLevelArray().length - 1;
            } else {
                xNextStep = player.getX() + player.getxVelocity();
            }
        }
    }

    private void moveMonster(Monster monster) {
        if (monster.getxVelocity() < 0) {
            if (monster.getX() + monster.getxVelocity() < 0) {
                xNextStep = 0;
            } else {
                xNextStep = monster.getX() + monster.getxVelocity();
            }
        } else {
            if (monster.getX() + monster.getxVelocity() >= level.getLevelArray().length) {
                xNextStep = level.getLevelArray().length - 1;
            } else {
                xNextStep = monster.getX() + monster.getxVelocity();
            }
        }
        if (level.getLevelArray()[xNextStep][monster.getY()] != Blocks.GROUND) {
            monster.setX(xNextStep);
        } else {
            monster.setxVelocity(monster.getxVelocity() * (-1));
        }
    }

    private void moveMonsters() {
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
