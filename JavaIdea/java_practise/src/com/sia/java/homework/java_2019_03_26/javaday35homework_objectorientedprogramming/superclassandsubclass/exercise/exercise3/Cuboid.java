package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass.exercise.exercise3;

public class Cuboid extends Rectangle{
    private float height;

    public Cuboid(){
        System.out.println("长方体有长,宽,高。");
    }
    public float calcBulk (float width, float length,float height) {
        return width*length*height;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
