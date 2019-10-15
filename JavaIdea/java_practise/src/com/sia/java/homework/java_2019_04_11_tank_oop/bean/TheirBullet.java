package com.sia.java.homework.java_2019_04_11_tank_oop.bean;

import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import java.awt.*;

public class TheirBullet extends Bullet {

    private int num;
    private Enemy e;
    private Thread t;

    public TheirBullet( Enemy e,Player p ) {
        super();
        this.e = e;
        this.setP( p );
        this.setDirection( e.getD() );
        this.setUi( e.getUi() );;
        this.setX( e.getX() );
        this.setY( e.getY() );
        t = new Thread( this );
        t.start();
    }

    @Override
    public void draw(Graphics g) {
        if ( isCanDo() ) {
            synchronized ( this.getP().getUi().theirBullets ) {
                int i = this.getX() * this.getWidth();
                int j = this.getY() * this.getHeight();
                g.drawImage(Resource.theirBullet, i + 10, j + 10, i + this.getWidth() - 10, j + this.getHeight() - 10, num * 32, 0, num * 32 + 32, 32, null);
                num++;
                if (num == 4) num = 0;
            }
        }
    }

    @Override
    public void run() {
        while ( isCanDo() ) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int m = this.getX();
            int n = this.getY();
            if (this.getDirection() == 0) {
                if (n < 9) {
                    destroyBlock(m, n);
                } else setCanDo(false);
                this.setY(this.getY() + 1);
            }
            if (this.getDirection() == 1) {
                if (m < 17) {
                    destroyBlock(m, n);
                } else setCanDo(false);
                this.setX(this.getX() + 1);
            }
            if (this.getDirection() == 2) {
                if (n >= 0) {
                    destroyBlock(m, n);
                } else setCanDo(false);
                this.setY(this.getY() - 1);
            }
            if (this.getDirection() == 3) {
                if (m >= 0) {
                    destroyBlock(m, n);
                } else setCanDo(false);
                this.setX(this.getX() - 1);
            }
            getP().getUi().repaint();
        }
    }

    private void makeBoom() {
        Boom boom = new Boom(this.getX(), this.getY(), this.getP());
        this.getP().getUi().booms.add(boom);
    }

    private void destroyBlock(int m, int n) {
        if ( (getUi().level[n][m] == 2 || getUi().level[n][m] > 4) && getUi().level[n][m]!=6 ) {
            getUi().level[n][m] = 0;
            makeBoom();
            setCanDo(false);
        } else if (getUi().level[n][m] == 3) {
            makeBoom();
            setCanDo(false);
        } else if ( getP().getX()==m && getP().getY() == n ){
            getP().setAlive( false );
            getP().setX( -1 );
            getP().setY( -1 );
            makeBoom();
            setCanDo(false);
        }
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Enemy getE() {
        return e;
    }

    public void setE(Enemy e) {
        this.e = e;
    }

    @Override
    public Thread getT() {
        return t;
    }
}
