package com.sia.java.homework.java_2019_04_11_tank_oop.bean;


import java.awt.*;

public abstract class Element {
    int x;
    int y;
    final int width = 50;
    final int height = 50;

    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

