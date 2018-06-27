public class Logic {
    Player player;
    Monster[] monsters;
    Level level;
    int jumpCounter;
    int yNextStep;
    int xNextStep;
    boolean canJump = true;

    public Logic(Player player, Level level, Monster[] monsters) {
        this.level = level;
        this.player = player;
        this.monsters = monsters;
    }

    public void movePlayer() {
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
        for (Monster monster : monsters) {
            moveMonster(monster);

        }
    }


    public boolean isAlive() {
        for (int i = 0; i < monsters.length; i++) {
            if (monsters[i].getX() == player.getX() && monsters[i].getY() == player.getY()) {
                return false;
            }

        }
        return true;
    }
}
