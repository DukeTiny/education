package com.sia.java.homework.java_2019_04_11_tank_oop.bean;

import com.sia.java.homework.java_2019_04_11_tank_oop.ui_and_frame.UI;
import com.sia.java.homework.java_2019_04_11_tank_oop.util.Resource;

import java.awt.*;

public class Player extends Element {

    private int directionX;
    private int directionY;
    private UI ui;
    private boolean alive = true;

    public Player( UI ui, int x, int y ){
        this.ui = ui;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw( Graphics g ) {
        if( alive ) {
            g.drawImage(Resource.player, 50 * x, 50 * y, 50 * x + 50, 50 * y + 50, this.directionX * 32, this.directionY * 32, this.directionX * 32 + 32, this.directionY * 32 + 32, null);
        }
    }

    public int getDirectionX() {
        return directionX;
    }

    public void setDirectionX(int directionX) {
        this.directionX = directionX;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
