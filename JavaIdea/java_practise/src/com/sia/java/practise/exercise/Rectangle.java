package com.sia.java.practise.exercise;

public class Rectangle {
    private int width;
    private int height;

    public void calcArea(int width,int height) {
        setHeight(height);
        setWidth(width);
        System.out.println(getHeight()*getWidth());
    }

    public void calcWholeLength(int width,int height) {
        setHeight(height);
        setWidth(width);
        System.out.println(2*(getWidth()+getHeight()));
    }

    public Rectangle(){
        this.width = 1;
        this.height = 1;
    }
    public Rectangle(int length) {
        this.width = length;
        this.height = length;
    }

    public Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
