package com.cxz.b_parameter;

import java.util.Date;

public class Foo {
    private String name;
    private Date birthday;
    private Double money;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", money=" + money +
                '}';
    }
}
