package supergame.game.gameobjects;

public enum Blocks {
    GROUND(1), SKY(0), MONSTER(2), GOAL(3), PLAYER(4);
    private int value;

    Blocks(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
}
