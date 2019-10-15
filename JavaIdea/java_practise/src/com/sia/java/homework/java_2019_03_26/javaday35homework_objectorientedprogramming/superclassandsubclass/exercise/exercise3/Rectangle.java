package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass.exercise.exercise3;

public class Rectangle {

    private float width;
    private float length;
    public Rectangle(){
        System.out.println("长方形只有长和宽");
    }

    public float calcArea(float width,float length){
        return width*length;
    }
    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
