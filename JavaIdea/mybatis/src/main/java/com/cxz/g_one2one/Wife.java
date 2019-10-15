package com.cxz.g_one2one;

import java.io.Serializable;

public class Wife implements Serializable {

    private Integer wid;
    private String wName;
    private Husband husband;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "wid=" + wid +
                ", wName='" + wName +
                '}';
    }

}
