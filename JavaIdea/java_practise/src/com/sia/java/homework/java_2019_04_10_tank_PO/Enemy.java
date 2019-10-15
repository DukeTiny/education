package com.sia.java.homework.java_2019_04_10_tank_PO;

import javax.annotation.Resources;
import javax.swing.*;
import java.awt.*;

public class Enemy extends Thread {
    int x;
    int y;
    private UI ui;
    private int d;
    private Image tank = new ImageIcon( Resources.class.getResource("/img/player2.png") ).getImage();

    public Enemy( int x, int y,UI ui ) {
        this.x = x;
        this.y = y;
        this.ui = ui;
        if ( ui.directionY==0 ) d=2;
        else if ( ui.directionY==2 ) d=0;
        else d = ui.directionY;
    }

    public void draw(  Graphics g ) {
        g.drawImage( this.tank,x*50,y*50,x*50+50,y*50+50,0,28*d,28,28*d+28,null);

    }

    public void run( ){
        while ( true ) {
            try{
                Thread.sleep( 300 );
            }
            catch ( InterruptedException e) {
                e.printStackTrace();
            }
            switch ( d ){
                case 3:
                    if ( x>=0 ){
                        if ( x==0 ) {
                            do {
                                d = (int)( Math.random() * 4 );
                            } while (d == 3);
                        }
                        else if ( ui.points[y][x-1]==1 || ui.points[y][x-1]==3 || ui.points[y][x-1]==4  ){
                            do {
                                d = (int)( Math.random() * 4 );
                            } while (d == 3);
                        }
                        if ( d==3 ) x--;
                    }
                    break;
                case 2:
                    if ( y>=0 ){
                        if ( y==0 ){
                            do {
                                d = (int)( Math.random() * 4 );
                            } while ( d==2 );
                        }
                        else if ( ui.points[y-1][x]==1 || ui.points[y-1][x]==3 || ui.points[y-1][x]==4  ) {
                            do {
                                d = (int)( Math.random() * 4 );
                            } while ( d==2 );
                        }
                        if ( d==2 ) y--;
                    }
                    break;
                case 1:
                    if ( x<=31 ) {
                        if ( x==31 ) {
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 1);
                        }
                        else if (ui.points[y][x+1] == 1 || ui.points[y][x + 1] == 3 || ui.points[y][x + 1] == 4) {
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 1);
                        }
                        if (d == 1) x++;
                    }
                    break;
                case 0:
                    if ( y<=14 ) {
                        if ( y==14 ){
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 0);
                        }
                        else if ( ui.points[y+1][x] == 1 || ui.points[y+1][x] == 3 || ui.points[y+1][x] == 4) {
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 0);
                        }
                        if (d == 0) y++;
                    }
                    break;
            }
            ui.repaint();
        }
    }

}
