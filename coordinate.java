package com.javaEE.Paint;



import java.awt.*;

/**
 * @author !qk
 * @version 1.0
 */
public class coordinate extends Mypanel_ {
    private static int Speed = 10;
    public static MyTank move(MyTank MyTank,int symbol){
        switch (symbol) {
            case 0:
                MyTank.setRealY(MyTank.getRealY() - MyTank.getSpeed());
                break;
            case 1:
                MyTank.setRealY(MyTank.getRealY() + MyTank.getSpeed());
                break;
            case 2:
                MyTank.setRealX(MyTank.getRealX() - MyTank.getSpeed());
                break;
            case 3:
                MyTank.setRealX(MyTank.getRealX() + MyTank.getSpeed());
                break;
        }
        MyTank.setStatus(symbol);
        MyTank.setDirection(symbol);
        return MyTank;
    }
    public static ElmyTank move1(ElmyTank MyTank,int symbol){

        switch (symbol) {
            case 0:
                if (MyTank.getRealY() - Speed >= 0 && MyTank.getRealY() - Speed <= 800) {
                    MyTank.setRealY(MyTank.getRealY() - Speed);
                }
                break;
            case 1:
                if (MyTank.getRealY() - Speed >= 0 && MyTank.getRealY() - Speed <= 800) {
                    MyTank.setRealY(MyTank.getRealY() + Speed);
                }
                break;
            case 2:
                if (MyTank.getRealX() - Speed >= 0 && MyTank.getRealX() - Speed <= 1500) {
                    MyTank.setRealX(MyTank.getRealX() - Speed);
                }
                break;
            case 3:
                if (MyTank.getRealX() - Speed >= 0 && MyTank.getRealX() - Speed <= 1500) {
                    MyTank.setRealX(MyTank.getRealX() + Speed);
                }
                break;
        }
        MyTank.setStatus(symbol);
        MyTank.setDirection(symbol);
        return MyTank;
    }
}
