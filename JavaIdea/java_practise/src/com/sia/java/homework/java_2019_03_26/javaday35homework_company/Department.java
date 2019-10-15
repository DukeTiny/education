package com.sia.java.homework.java_2019_03_26.javaday35homework_company;

public class Department {

    static Department[] departments = new Department[0];

    private String departmentID;
    private String departmentName;
    private int departmentCount;

    public Department(){}

    public Department ( String departmentID,String departmentName ){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentCount = 0;
    }



    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentCount() {
        return departmentCount;
    }

    public void setDepartmentCount(int departmentCount) {
        this.departmentCount = departmentCount;
    }

}
