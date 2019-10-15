package com.sia.java.practise.exercise;

public class LaptopTest {

    public static void main(String[] args) {
        LaptopTest doTest = new LaptopTest();
        doTest.testLaptop();
    }

    public void testLaptop() {
        Laptop laptop1 = new Laptop();
        laptop1.showDetails();
        Laptop laptop2 = new Laptop('红',7600);
        laptop2.showDetails();
    }

}
