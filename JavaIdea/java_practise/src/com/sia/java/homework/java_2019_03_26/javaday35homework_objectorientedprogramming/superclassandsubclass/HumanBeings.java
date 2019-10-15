package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass;

public abstract class HumanBeings {
    private String name;
    private int age;

    public abstract void study();

    public void eat(){
        System.out.println("Eat meat");
    }
    public void drink(){
        System.out.println("Drink wine");
    }
    public void sleep(){
        System.out.println("Sleep on the bed");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
