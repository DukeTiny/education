package com.sia.java.homework.java_2019_03_26.javaday35homework_company;

public class Employee {

    static Employee[] employees = new Employee[0];

    private int eID;
    private String eName;
    private String eBirth;
    private String eSex;
    private float eSalary;
    private String eDepartment;

    public Employee(){}

    public Employee(int eID,String eName,String eBirth,String eSex,float eSalary,String eDepartment){
        this.eID = eID;
        this.eName = eName;
        this.eBirth = eBirth;
        this.eSex = eSex;
        this.eSalary = eSalary;
        this.eDepartment = eDepartment;
    }



    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteBirth() {
        return eBirth;
    }

    public void seteBirth(String eBirth) {
        this.eBirth = eBirth;
    }

    public String geteSex() {
        return eSex;
    }

    public void seteSex(String eSex) {
        this.eSex = eSex;
    }

    public float geteSalary() {
        return eSalary;
    }

    public void seteSalary(float eSalary) {
        this.eSalary = eSalary;
    }

    public String geteDepartment() {
        return eDepartment;
    }

    public void seteDepartment(String eDepartment) {
        this.eDepartment = eDepartment;
    }
}
