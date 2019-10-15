package com.sia.java.practise.exercise;

public class Point {
    private float x;
    private float y;

    public Point(){
    }
    public Point(float xo,float yo){
        this.x = xo;
        this.y = yo;
    }
    public void movePoint(float dx,float dy){
        setX(getX()+dx);
        setY(getY()+dy);
    }
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public static void main(String[] args) {
        Point p1 = new Point();
        p1.movePoint(5.5F,4.4F);
        System.out.println(p1.getX() + "." + p1.getY());
        Point p2 = new Point(3.4F,6.3F);
        p2.movePoint(6.9F,9.4F);
        System.out.println(p2.getX() + "." + p2.getY());

    }

}
