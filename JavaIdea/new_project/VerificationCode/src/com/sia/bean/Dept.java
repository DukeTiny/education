package com.sia.bean;

public class Dept {

    private String deptname;
    private String loc;
    private Integer num;

    public Dept() {}

    public Dept(String deptname, String loc, Integer num) {
        this.deptname = deptname;
        this.loc = loc;
        this.num = num;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
