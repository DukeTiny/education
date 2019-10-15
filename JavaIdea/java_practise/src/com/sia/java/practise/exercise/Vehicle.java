package com.sia.java.practise.exercise;

public class Vehicle {
    private final String brand;
    private String color;
    private double speed;


    public Vehicle(){
        this.brand = "Porshe";
    }
    public Vehicle ( String brand,String color) {
        this.brand = brand;
        this.color = color;
        this.speed = 0.0D;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void run() {
        System.out.println(getBrand() + "品牌的车在奔跑的时候因为起本身自重的原因，在速度比较高大于180km/h的时候，汽车依然可以平稳的奔跑");
    }


}
