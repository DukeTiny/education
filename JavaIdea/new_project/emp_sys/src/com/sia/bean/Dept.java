package com.sia.bean;

public class Dept {
    private Integer deptno;    // 部门编号
    private String dname;   // 部门名称
    private String loc;    // 所在城市

    public Dept() {}

    public Dept(Integer deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getdeptno() {
        return deptno;
    }

    public void setdeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getloc() {
        return loc;
    }

    public void setloc(String loc) {
        this.loc = loc;
    }
}
