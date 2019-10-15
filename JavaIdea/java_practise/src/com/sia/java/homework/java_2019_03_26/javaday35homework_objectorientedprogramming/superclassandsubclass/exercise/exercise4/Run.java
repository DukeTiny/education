package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass.exercise.exercise4;

public class Run {
    public static void main(String[] args) {
        AutoCar autocar = new AutoCar();
        System.out.println( "该车的减速度为：" + autocar.speedCutSlow(30.0F) );
        System.out.println( "该车的加速度为：" + autocar.speedUp(20.0F));
        AutoCar car = new AutoCar("White",1000.5F,160.5F,"好空调","顶呱呱牌");
        System.out.printf( "该车的属性为：颜色 %s,重量 %f,速度 %f,空调 %s, CD机 %s",car.getColor(),car.getWeight(),car.getSpeed(),car.getAC(),car.getCD() );

    }
}
