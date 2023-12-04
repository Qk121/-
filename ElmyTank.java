package com.javaEE.Paint;

import java.awt.*;

/**
 * @author !qk
 * @version 1.0
 */
public class ElmyTank extends tank{
    public ElmyTank(){}
    public ElmyTank(int realX, int realY) {
        super(realX, realY);
    }

    public void DiTanks(int x, int y, Graphics g) {
        int status = super.getDirection();
        g.setColor(Color.yellow);
        switch (status) {
            case 0:
                g.fill3DRect(x, y, 10, 40,false);
                g.fill3DRect(x + 20, y, 10, 40,false);
                g.fill3DRect(x + 10, y + 10, 10, 20,false);
                g.fillOval(x + 10, y + 15, 10, 10);
                g.drawLine(x + 15, y + 20, x + 15, y);
                break;
            case 1:
                g.fill3DRect(x, y, 10, 40,false);
                g.fill3DRect(x + 20, y, 10, 40,false);
                g.fill3DRect(x + 10, y + 10, 10, 20,false);
                g.fillOval(x + 10, y + 15, 10, 10);
                g.drawLine(x + 15, y + 20, x + 15, y + 40);
                break;
            case 2:
                g.fill3DRect(x, y, 40, 10,false);
                g.fill3DRect(x, y + 20, 40, 10,false);
                g.fill3DRect(x + 10, y + 10, 20, 10,false);
                g.fillOval(x + 15, y + 10, 10, 10);
                g.drawLine(x + 20, y + 15, x, y + 15);
                break;
            case 3:
                g.fill3DRect(x, y, 40, 10,false);
                g.fill3DRect(x, y + 20, 40, 10,false);
                g.fill3DRect(x + 10, y + 10, 20, 10,false);
                g.fillOval(x + 15, y + 10, 10, 10);
                g.drawLine(x + 20, y + 15, x + 40, y + 15);
                break;
        }
    }
}
