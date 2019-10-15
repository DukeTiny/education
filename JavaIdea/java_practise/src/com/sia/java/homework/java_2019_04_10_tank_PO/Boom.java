package com.sia.java.homework.java_2019_04_10_tank_PO;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

public class Boom extends Thread {
    private int x;
    private int y;
    private UI ui;
    private int i=0;
    private Image boom = new ImageIcon( Resources.class.getResource( "/img/boom.png")).getImage();
    public Boom( int y,int x,UI ui) {
        this.x = x;
        this.y = y;
        this.ui = ui;
    }

    public void draw( Graphics g ) {
        g.drawImage(boom,x*50,y*50,x*50+50,y*50+50,192*i,0,i*192+192,192,null);
    }


    public void run () {
        while ( true ){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ( i<10 ) i++;
            ui.repaint();
        }
    }

    public int getI() {
        return i;
    }
}
