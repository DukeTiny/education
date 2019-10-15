package com.sia.java.practise.exercise;

public class Circle {
    private float radius;
    private static final float PI = 3.1412313f;

    public Circle(float radius ) {
        this.radius = radius;
    }
    public void calcArea () {
        System.out.println(PI*this.radius*this.radius);
    }
    public void calcWholeLenght () {
        System.out.println(2*PI*this.radius);
    }

}
