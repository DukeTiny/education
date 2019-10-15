package com.cxz.j_di;


import java.io.Serializable;

public class User implements Serializable {

    private Integer id;
    private String name;
    private Car car;

    public User() {}

    public User(Integer id, String name,Car car) {
        this.id = id;
        this.name = name;
        this.car = car;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
