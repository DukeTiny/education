package com.sia.java.homework.java_2019_03_26.javaday35homework_1;

public class Rect {
    protected float width;
    protected float height;

    public Rect() {
        this.width = 10.0F;
        this.height = 10.0F;
    }

    public Rect(float width, float height) {
        this.width = width;
        this.height = height;
    }
    public float calcArea() {
        return this.width*this.height;
    }
    public float calcWholeLength() {
        return 2*( this.width + this.height );
    }
}
