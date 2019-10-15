package com.cxz.bean;


import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private int id;
    private String username;
    private Date birthday;
    private double money;

    public User() {}

    public User(int id, String username, Date birthday, double money) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + this.username +
                ", birthday=" + this.birthday +
                ", money=" + this.money +
                '}';
    }
}
