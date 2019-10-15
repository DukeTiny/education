package com.sia.java.practise.school_management_system;

import java.util.ArrayList;
import java.util.List;

public class StudentInformation {

    static List<StudentInformation> userInfo = new ArrayList<StudentInformation>();
    private String id;
    private String name;
    private String sex;
    private int age;
    private int classId;


    static {
        StudentInformation stuInfo1 = new StudentInformation();
        stuInfo1.setId("02100653");
        stuInfo1.setName("王虎");
        stuInfo1.setSex("男");
        stuInfo1.setAge(27);
        stuInfo1.setClassId(2);
        userInfo.add(stuInfo1);
        userInfo.add(new StudentInformation("马丁","男",26,2));

    }

    public StudentInformation(){}
    public StudentInformation(String name,String sex,int age,int classId){
        this.id = "0" + String.valueOf(Integer.parseInt(userInfo.get(userInfo.size()-1).getId())+1);
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.classId = classId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = age;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }



}
