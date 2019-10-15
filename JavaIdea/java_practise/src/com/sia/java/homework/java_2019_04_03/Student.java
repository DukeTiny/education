package com.sia.java.homework.java_2019_04_03;

public class Student {
    private String no;
    private String sID;
    private String sName;
    private String sBirth;
    private String sSex;
    private String sDegree;
    private String sClass;

    public Student() {
    }

    public Student(String no, String sID, String sName, String sBirth, String sSex, String sDegree, String sClass) {
        this.no = no;
        this.sID = sID;
        this.sName = sName;
        this.sBirth = sBirth;
        this.sSex = sSex;
        this.sDegree = sDegree;
        this.sClass = sClass;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsBirth() {
        return sBirth;
    }

    public void setsBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsDegree() {
        return sDegree;
    }

    public void setsDegree(String sDegree) {
        this.sDegree = sDegree;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }
}
