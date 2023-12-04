package com.javaEE.Paint;

import java.awt.*;
import java.util.Vector;

/**
 * @author !qk
 * @version 1.0
 */
public class bullet extends Mypanel_ implements Runnable{
    private int x;
    private int y;
    private int direct;
    private boolean symbol = false;
    private int realX;
    private int realY;

    public int getRealX() {
        return realX;
    }

    public int getRealY() {
        return realY;
    }

    public boolean isSymbol() {
        return symbol;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void setSymbol(boolean symbol) {
        this.symbol = symbol;
    }

    public bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public void generate(Graphics g){
        int sysmobl = 0;
        switch (direct){
            case 0:
                g.fillRect(realX = x + 13,realY = y, 5, 5);
                break;
            case 1:
                g.fillRect(realX = x + 13, realY = y + 40, 5, 5);
                break;
            case 2:
                g.fillRect(realX = x, realY = y + 13, 5, 5);
                break;
            case 3:
                g.fillRect(realX = x + 40, realY = y + 13 ,5, 5);
                break;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirect() {
        return direct;
    }

    @Override
    public void run() {
        while (symbol) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if ((y <= 800 && y >= 0) && (x <= 1500 && x >= 0)) {
                if (direct == 0) {
                    y -= 15;
                } else if (direct == 1) {
                    y += 15;
                } else if (direct == 2) {
                    x -= 15;
                } else if (direct == 3) {
                    x += 15;
                }
            }else symbol = false;
        }
    }
}
