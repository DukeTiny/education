package com.sia.java.homework.java_2019_04_11_tank_oop.bean;

import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import java.awt.*;

public class Block extends Element{
    private int type;
    public Block( int type ) {
        this.type = type;
    }

    @Override
    public void draw( Graphics g ) {
        Image image = null;
        switch( type ){
            case 1:
                image = Resource.grass;
                break;
            case 2:
                image = Resource.wall;
                break;
            case 3:
                image = Resource.iron;
                break;
            case 4:
                image = Resource.river;
                break;
            case 5:
                image = Resource.myBoss;
                break;
            case 6:
                image = Resource.enemyBoss;
                break;
        }
        if ( type==1 ) g.drawImage( image,(int) (this.x*50+50*0.15),(int)(this.y*50+50*0.15),(int)(this.getWidth()*0.7),(int)(this.getHeight()*0.7),null );
        else g.drawImage( image,this.x*50,this.y*50,this.getWidth(),this.getHeight(),null );
    }
}
