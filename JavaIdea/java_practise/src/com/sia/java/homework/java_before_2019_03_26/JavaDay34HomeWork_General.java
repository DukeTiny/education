package com.sia.java.homework.java_before_2019_03_26;


public class JavaDay34HomeWork_General {

    private String genName;
    private int genStrength;
    private int genIQ;
    private int genHP;
    private String wing;

    public JavaDay34HomeWork_General(){}

    public JavaDay34HomeWork_General( String genName,String wing ){
        this.genName = genName;
        this.wing = wing;
        this.genStrength = (int)(Math.random()*50) + 50;
        this.genIQ = (int)(Math.random()*50) + 50;
        this.genHP = (int)(Math.random()*50) + 50;
    }


    public String getGenName() {
        return genName;
    }

    public void setGenName(String genName) {
        this.genName = genName;
    }

    public int getGenStrength() {
        return genStrength;
    }

    public void setGenStrength(int genStrength) {
        this.genStrength = genStrength;
    }

    public int getGenIQ() {
        return genIQ;
    }

    public void setGenIQ(int genIQ) {
        this.genIQ = genIQ;
    }

    public int getGenHP() {
        return genHP;
    }

    public void setGenHP(int genHP) {
        this.genHP = genHP;
    }

    public String getWing() {
        return wing;
    }

    public void setWing(String wing) {
        this.wing = wing;
    }
}
