package com.sia.java.homework.java_2019_03_26.javaday35homework_objectorientedprogramming.superclassandsubclass;

public class Student extends HumanBeings {
    private int stuID;
    private float score;

    public void doExam() {
        System.out.println("Exam is the worst thing");
    }

    @Override
    public void study() {
        System.out.println("I study through reading books");
    }

    public int getStuID() {
        return stuID;
    }

    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
