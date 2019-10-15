package com.sia.bean;

public class Stu {
    private Integer sid;
    private String sName;
    private String sPhoto;

    public Stu() {}

    public Stu(Integer sid, String sName, String sPhoto) {
        this.sid = sid;
        this.sName = sName;
        this.sPhoto = sPhoto;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPhoto() {
        return sPhoto;
    }

    public void setsPhoto(String sPhoto) {
        this.sPhoto = sPhoto;
    }
}
