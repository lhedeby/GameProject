package supergame.game.gameobjects;

import com.googlecode.lanterna.terminal.Terminal;

public abstract class GameObject {

    private int x, y;
    private String symbol;
    private Terminal.Color color;
    private int yVelocity;
    private int xVelocity;


    public GameObject(int x, int y, String symbol, Terminal.Color color) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
        this.color = color;
        this.xVelocity = 0;
        this.yVelocity = 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getSymbol() {
        return symbol;
    }

    public Terminal.Color getColor() {
        return color;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }


    public int getyVelocity() {
        return yVelocity;
    }

    public int getxVelocity() {
        return xVelocity;
    }
}
