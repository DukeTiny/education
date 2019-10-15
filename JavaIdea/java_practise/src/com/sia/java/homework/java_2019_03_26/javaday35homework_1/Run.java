package com.sia.java.homework.java_2019_03_26.javaday35homework_1;

public class Run {

    public static void main(String[] args) {
        PlainRect pr = new PlainRect(20,10,10,10);
        System.out.println(pr.calcArea());
        System.out.println(pr.calcWholeLength());
        System.out.println(pr.ifInside(25.5F,13F));
    }

}
