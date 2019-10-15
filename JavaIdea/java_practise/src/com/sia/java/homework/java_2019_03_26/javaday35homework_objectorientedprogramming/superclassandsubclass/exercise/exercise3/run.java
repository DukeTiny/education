package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass.exercise.exercise3;

public class run {
    public static void main(String[] args) {
        Cuboid c = new Cuboid();
        c.setHeight(5.0F);
        c.setLength(3.5F);
        c.setWidth(6.3F);
        System.out.println( "这个长方体的体积为：" + c.calcBulk(c.getWidth(),c.getHeight(),c.getLength()) );
        System.out.println( "这个长方体的底面积为："+ c.calcArea(c.getWidth(),c.getLength()));
    }
}
