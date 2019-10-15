package com.sia.bean;

public class User {
    private Integer uid;
    private String uname;
    private String upwd;
    private String urole="普通用户";
    public static final String NORMAL_STATUS = "Normal";
    private String ustatus= NORMAL_STATUS;
    public static final String Frezzy_STATUS = "Frezzied";

    public User() {}

    public User(String uname, String upwd) {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUrole() {
        return urole;
    }

    public void setUrole(String urole) {
        this.urole = urole;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public static String getNormalStatus() {
        return NORMAL_STATUS;
    }

    public static String getFrezzy_STATUS() {
        return Frezzy_STATUS;
    }
}
