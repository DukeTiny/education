package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass.exercise.exercise4;

public class Auto {
    private static  final int wheels = 4;
    private String color;
    private float weight;
    private float speed;

    public Auto() {
    }
    public Auto( String color,float weight,float speed) {
        this.color = color;
        this.weight = weight;
        this.speed = speed;
    }

    public float speedUp( float f) {
        return this.speed+f;
    }
    public float speedCutSlow( float f) {
        return this.speed-f;
    }

    public int getWheels() {
        return wheels;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setweight(float weight) {
        this.weight = weight;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
