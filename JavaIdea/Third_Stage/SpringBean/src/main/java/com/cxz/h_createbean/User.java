package com.cxz.h_createbean;


import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void methodInit() {
        System.out.println("User.methodInit");
    }
    public void methodInit2() {
        System.out.println("User.methodInit2");
    }



    public void setId(Integer id) {
        System.out.println("id = [" + id + "]");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name = [" + name + "]");
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
