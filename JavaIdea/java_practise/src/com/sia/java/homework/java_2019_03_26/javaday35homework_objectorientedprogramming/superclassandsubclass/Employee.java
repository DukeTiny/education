package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass;

public class Employee  extends HumanBeings {
    private int eID;
    private int eSalary;

    public void work(){
        System.out.println("Work makes me happy");
    }

    @Override
    public void study() {
        System.out.println("I study by through the video");
    }
}
