package com.sia.java.practise.exercise;

public class VehicleTest {

    public static void main(String[] args) {
        VehicleTest vehicleTest = new VehicleTest();
        vehicleTest.test();
    }
    public void test() {
        Vehicle brand = new Vehicle("Benz","Black");
        brand.run();
        System.out.println("这是一辆" + brand.getBrand() + "牌汽车,颜色为:" + brand.getColor());
    }

}
