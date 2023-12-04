package com.javaEE.Paint;


/**
 * @author !qk
 * @version 1.0
 */
public class tank{
    public tank() {
    }

    public tank(int realX, int realY) {
        this.realX = realX;
        this.realY = realY;
    }

    private int realX = 0;
    private int realY = 0;
    private int status = 0;
    private int speed = 5;
    private int direction = 0;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRealX() {
        return realX;
    }

    public void setRealX(int realX) {
        this.realX = realX;
    }

    public int getRealY() {
        return realY;
    }

    public void setRealY(int realY) {
        this.realY = realY;
    }

}
