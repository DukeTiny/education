package com.sia.java.homework.java_2019_03_26.javaday35homework_1;

public class PlainRect extends Rect {
    protected float startX;
    protected float startY;

    public PlainRect() {
        super(0,0);
        this.startX = 0;
        this.startY = 0;
    }

    public PlainRect ( float width,float height,float startX,float startY ) {
        super( width,height);
        this.startX = startX;
        this.startY = startY;
    }

    public boolean ifInside ( float doubleX,float doubleY ) {
        return ( doubleX>=this.width && doubleX<=this.width + this.startX ) &&
                ( doubleY>=this.height && doubleY<=this.height + this.startY);
    }





}
