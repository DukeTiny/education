package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass.exercise.exercise4;

public class AutoCar extends Auto {
    private String AC;
    private String CD;

    public AutoCar(){}

    public AutoCar(String AC, String CD) {
        this.AC = AC;
        this.CD = CD;
    }

    public AutoCar(String color, float weight, float speed, String AC, String CD) {
        super(color, weight, speed);
        this.AC = AC;
        this.CD = CD;
    }

    @Override
    public float speedUp(float f) {
        return f;
    }

    @Override
    public float speedCutSlow(float f) {
        return f;
    }

    public String getAC() {
        return AC;
    }

    public void setAC(String AC) {
        this.AC = AC;
    }

    public String getCD() {
        return CD;
    }

    public void setCD(String CD) {
        this.CD = CD;
    }
}
