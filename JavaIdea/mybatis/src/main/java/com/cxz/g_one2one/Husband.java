package com.cxz.g_one2one;

import java.io.Serializable;

public class Husband implements Serializable {

    private Integer hid;
    private String hName;
    private Wife wife;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "hid=" + hid +
                ", hName='" + hName  +
                '}';
    }

}
