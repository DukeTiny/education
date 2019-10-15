package com.sia.java.homework.java_2019_04_11_tank_oop.bean;

import com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame.UI;
import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import java.awt.*;

public class Enemy extends Element implements Runnable {
    
    private UI ui;
    private int d;
    public boolean alive = true;
    private Thread t;
    
    public Enemy( UI ui,int x,int y ) {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.d = (int)(Math.random()*4);
        t = new Thread( this );
        t.start();
    }

    @Override
    public void draw( Graphics g ) {
        if( alive ) {
            g.drawImage(Resource.enemy, x * 50, y * 50, x * 50 + 50, y * 50 + 50, 0, 28 * d, 28, 28 * d + 28, null);
        }
    }

    @Override
    public void run() {

        while ( alive ) {
            try{
                Thread.sleep( 400 );
            }
            catch ( InterruptedException e) {
                e.printStackTrace();
            }
            int x = this.getX();
            int y = this.getY();
            int fireNum = (int)(Math.random()*3);
            if ( fireNum==1 ) d = (int)( Math.random() * 4 );
            switch ( d ){
                case 3:
                    if ( x>=0 ){
                        if ( x==0 ) {
                            do {
                                d = (int)( Math.random() * 4 );
                            } while (d == 3);
                        }
                        else if ( ui.level[y][x-1]>1 && ui.level[y][x-1]<=4  ){
                            do {
                                d = (int)( Math.random() * 4 );
                            } while (d == 3);
                        }
                        if ( d==3 ) {
                            this.setX( x-1 );
                        }
                    }
                    break;
                case 2:
                    if ( y>=0 ){
                        if ( y==0 ){
                            do {
                                d = (int)( Math.random() * 4 );
                            } while ( d==2 );
                        }
                        else if ( ui.level[y-1][x]>1 && ui.level[y-1][x]<=4  ) {
                            do {
                                d = (int)( Math.random() * 4 );
                            } while ( d==2 );
                        }
                        if ( d==2 ) {
                            this.setY( y-1 );
                        }
                    }
                    break;
                case 1:
                    if ( x<17 ) {
                        if ( x==16 ) {
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 1);
                        }
                        else if (ui.level[y][x+1]>1 && ui.level[y][x + 1]<=4) {
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 1);
                        }
                        if (d == 1) {
                            this.setX( x+1 );
                        }
                    }
                    break;
                case 0:
                    if ( y<9 ) {
                        if ( y==8 ){
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 0);
                        }
                        else if ( ui.level[y+1][x]>1 && ui.level[y+1][x]<=4 ) {
                            do {
                                d = (int) (Math.random() * 4);
                            } while (d == 0);
                        }
                        if (d == 0) {
                            this.setY( y+1 );
                        }
                    }
                    break;
            }
            if ( fireNum==0 ){
                TheirBullet tb = new TheirBullet( this,ui.getP() );
                ui.theirBullets.add( tb );
            }
        ui.repaint();
        }
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Thread getT() {
        return t;
    }
}
