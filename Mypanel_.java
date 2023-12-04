package com.javaEE.Paint;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author !qk
 * @version 1.0
 */
public class Mypanel_ extends JPanel implements KeyListener,Runnable {
    //private int symbol = 0;
    MyTank tank1 = null;
    MyTank tank2 = null;
    Vector<bullet> bullets;
    Vector<ElmyTank> elmyTanks;
    Vector<bullet> elmbullets;
    private double nowTime = 0;
    private double lastTime = 0;
    private double nowTime1 = 0;
    private double lastTime1 = 0;

    public Mypanel_(){
        tank1 = new MyTank(800,500);
        tank2 = new MyTank(400,500);
        bullets = new Vector<>();
        elmyTanks = new Vector<>();
        elmbullets = new Vector<>();
        for (int i = 2;i < 5;i ++) {
            ElmyTank elmyTank = new ElmyTank(100 * i, 50 * i);
            elmyTank.setDirection(1);
            elmyTanks.add(elmyTank);

        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画出背景板
        BackGroud backGroud = new BackGroud();
        backGroud.backGourd(g);
        //画出我方坦克
        tank1.tanks(tank1.getRealX(),tank1.getRealY(),g,tank1.getStatus());
        tank2.tanks(tank2.getRealX(),tank2.getRealY(),g,tank2.getStatus());
        //画出敌军坦克
        for (int i = 0;i < elmyTanks.size();i ++){
            elmyTanks.get(i).DiTanks(elmyTanks.get(i).getRealX(),elmyTanks.get(i).getRealY(),g);
        }
        //画出敌军子弹
        for (int i = 0;i < elmbullets.size();i ++){
            if (elmbullets.get(i).isSymbol() == true) {
                elmbullets.get(i).generate(g);
            }
        }
        //画出我方子弹
        for (int i = 0;i < bullets.size();i ++){
            if (bullets.get(i).isSymbol() == true) {
                bullets.get(i).generate(g);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            tank1 = coordinate.move(tank1,0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            tank1 = coordinate.move(tank1,1);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            tank1 = coordinate.move(tank1,2);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            tank1 = coordinate.move(tank1,3);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            tank2 = coordinate.move(tank2,0);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            tank2 = coordinate.move(tank2,1);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            tank2 = coordinate.move(tank2,2);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            tank2 = coordinate.move(tank2,3);
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            bullet bullet = new bullet(tank2.getRealX(),tank2.getRealY(),tank2.getDirection());
            bullet.setSymbol(true);
            bullets.add(bullet);
            new Thread(bullet).start();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void run(){

        while (true){
            repaint();
            elmShoot();
            elmBoom();
            elmGo();
        }
    }
    public void elmShoot(){//生成敌军子弹线程
        nowTime = System.currentTimeMillis();
        if (nowTime - lastTime > 3000){
            for (int i = 0;i < elmyTanks.size();i ++){
                bullet bullet1 = new bullet(elmyTanks.get(i).getRealX(),elmyTanks.get(i).getRealY(),elmyTanks.get(i).getDirection());
                bullet1.setSymbol(true);
                new Thread(bullet1).start();
                elmbullets.add(bullet1);
            }
            lastTime = System.currentTimeMillis();
        }
    }

    //敌军坦克爆炸
    public void elmBoom(){
        for (int i = 0;i < bullets.size();i ++){
            for (int j = 0;j < elmyTanks.size();j ++){
                if ((bullets.get(i).getRealX() > elmyTanks.get(j).getRealX() && bullets.get(i).getRealX() < (elmyTanks.get(j).getRealX() + 30)) && (bullets.get(i).getRealY() > elmyTanks.get(j).getRealY() && (bullets.get(i).getRealY() < elmyTanks.get(j).getRealY() + 40))) {
                    elmyTanks.remove(j);
                }
            }
        }
    }
    //随机坦克移动
    public void elmGo(){
        nowTime1 = System.currentTimeMillis();
        if (nowTime1 - lastTime1 > 1000) {
            for (int i = 0; i < elmyTanks.size(); i++) {
                elmyTanks.get(i).setDirection((Math.abs((int) (Math.random() * 10)) % 4));
                elmyTanks.set(i, coordinate.move1(elmyTanks.get(i), elmyTanks.get(i).getDirection()));
            }
            lastTime1 = System.currentTimeMillis();
        }
    }
}
