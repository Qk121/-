package com.javaEE.Paint;

import javax.swing.*;

/**
 * @author !qk
 * @version 1.0
 */
public class Main extends JFrame{
    public static void main(String[] args) {
        new Main();

    }

    public Main() {
        Mypanel_ mypanel = new Mypanel_();
        this.setSize(1500,800);
        this.add(mypanel);
        this.addKeyListener(mypanel);
        this.setVisible(true);
        new Thread(mypanel).start();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
