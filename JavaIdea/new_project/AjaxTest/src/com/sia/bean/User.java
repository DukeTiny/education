package com.sia.bean;

public class User {
    private Integer uid;
    private String uName;
    private String uPwd;
    private String uRole;
    private String uStatus;

    public User() {}

    public User(Integer uid, String uName, String upwd, String uRole, String uStatus) {
        this.uid = uid;
        this.uName = uName;
        this.uPwd = upwd;
        this.uRole = uRole;
        this.uStatus = uStatus;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuRole() {
        return uRole;
    }

    public void setuRole(String uRole) {
        this.uRole = uRole;
    }

    public String getuStatus() {
        return uStatus;
    }

    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }
}
