package com.sia.java.homework.java_2019_04_11_tank_oop.bean;

import com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame.UI;
import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Timer;

public class Bullet extends Element implements Runnable{

    private int direction;
    private  Player p;
    private boolean canDo = true;
    private UI ui;
    public Thread t;

    public Bullet() {}

    public Bullet( Player p ) {
        this.p = p;
        this.direction = this.p.getDirectionY();
        this.ui = p.getUi();
        this.setX( p.getX() );
        this.setY( p.getY() );
        t = new Thread( this );
        t.start();
    }

    @Override
    public void draw( Graphics g ) {
//        Timer time = new Tim
        if ( canDo ) {
            int i = this.getX() * this.getWidth();
            int j = this.getY() * this.getHeight();
//            if( direction==3) x--;
//            if( direction==2) y--;
//            if( direction==1) x++;
//            if( direction==0) y++;
            int n = (int) (Math.random() * this.getHeight()) / 4;
            g.drawImage( Resource.bullet, i + n, j + n, i + this.getWidth() - n, j + this.getHeight() - n, 0, 0, 192, 192, null);
        }
    }

    @Override
    public void run() {
        while ( canDo ) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int m = this.getX();
            int n = this.getY();
            if (this.direction == 0) {
                if (n < 9) {
                    destroyBlock(m, n);
                } else canDo = false;
                this.setY(this.getY() + 1);
            }
            if (this.direction == 1) {
                if ( m<17 ) {
                    destroyBlock(m, n);
                } else canDo = false;
                this.setX( this.getX() + 1);
            }
            if (this.direction == 2) {
                if ( n>=0 ) {
                    destroyBlock(m, n);
                } else canDo = false;
                this.setY( this.getY() - 1 );
            }
            if ( this.direction==3 ) {
                if ( m>=0 ) {
                    destroyBlock(m, n);
                } else canDo = false;
                this.setX( this.getX() - 1 );
            }
            p.getUi().repaint();
        }
    }
    private void makeBoom() {
        Boom boom = new Boom( this.getX(),this.getY(),this.p );
        this.p.getUi().booms.add( boom );
    }


    private void destroyBlock(int m, int n ){
        if ( ui.level[n][m]==2 || ui.level[n][m]>4  ) {
            if( ui.level[n][m]==6 ) ui.map.setEnemyBossIsAlive( false );
            ui.level[n][m] = 0;
            makeBoom();
            canDo = false;
        } else if ( ui.level[n][m]==3 ){
            makeBoom();
            canDo = false;
        } else{
            for ( Enemy e:ui.enemies ){
                if ( e.getX()==m && e.getY()==n ){
                    makeBoom();
                    for( TheirBullet t:p.getUi().theirBullets ){
                        t.setCanDo( false );
                    }
                    e.alive = false;
                    canDo = false;
                    break;
                }
            }
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

    public boolean isCanDo() {
        return canDo;
    }

    public void setCanDo(boolean canDo) {
        this.canDo = canDo;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public Thread getT() {
        return t;
    }
}
