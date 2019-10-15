package com.cxz.i_many2many;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private Integer sid;
    private String sName;
    private Set<Teacher> teachers = new HashSet<>();

    public Integer getId() {
        return sid;
    }

    public void setId(Integer id) {
        this.sid = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + sid +
                ", sName='" + sName + '\'' +
                '}';
    }
}
