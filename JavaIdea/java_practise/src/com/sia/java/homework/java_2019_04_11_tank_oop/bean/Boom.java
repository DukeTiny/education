package com.sia.java.homework.java_2019_04_11_tank_oop.bean;

import com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame.UI;
import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import java.awt.*;

public class Boom extends Element implements Runnable {

    private int direction;
    private int count = 0;
    private UI ui;

    Boom( int x, int y, Player p ) {
        this.setX( x );
        this.setY( y );
        ui = p.getUi();
        Thread t = new Thread( this );
        t.start();
    }
    Boom( int x, int y, Enemy e ) {
        this.setX( x );
        this.setY( y );
        ui = e.getUi();
        Thread t = new Thread( this );
        t.start();
        try {
            t.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void draw( Graphics g ) {
        if( count<9 ){
            int x = this.getX()*50;
            int y = this.getY()*50;
            g.drawImage( Resource.boom,x,y,x+50,y+50,192*count,0,192*count+192,192,null );
        }
    }

    @Override
    public void run() {
        while ( count<9 ){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            ui.repaint();
        }
    }
}
