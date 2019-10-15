package com.sia.java.homework.java_2019_04_10_tank_PO;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

public class Bullet extends Thread {

    int x;
    int y;
    private Image bullet = new ImageIcon( Resources.class.getResource( "/img/bullet.png" ) ).getImage();
    private UI ui;
    private int d;

    public Bullet ( UI ui ){
        this.x = ui.j;
        this.y = ui.i;
        d = ui.directionY;
        this.ui = ui;
    }
    public void draw( Graphics g ){
        plus();
        g.drawImage( bullet,x*50+10,y*50+10,x*50+40,y*50+40,d*32,0,d*32+32,32,null);
    }

    public void run() {
        while ( true ) {
            try {
                Thread.sleep( 100 );
            }
            catch ( InterruptedException e ){
                e.printStackTrace();
            }
            plus();
            ui.repaint();
        }
    }
    private void plus() {
        if ( d==0 ) y++;
        if ( d==1 ) x++;
        if ( d==2 ) y--;
        if ( d==3 ) x--;
    }
}
