package com.sia.java.practise.exercise;

public class Laptop {
    private char color;
    private int cpu;

    public Laptop(){}
    public Laptop(char color, int cpuNum) {
        this.color = color;
        this.cpu = cpuNum;
    }
    public void showDetails(){
        System.out.println(getColor());
        System.out.println(getCpu());
    }


    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }


}
