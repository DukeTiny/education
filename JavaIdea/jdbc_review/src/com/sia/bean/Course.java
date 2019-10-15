package com.sia.bean;

public class Course {
    private String cno;
    private String cname;
    private String cnum;

    public Course() {
    }

    public Course(String cno, String cname, String cnum) {
        this.cno = cno;
        this.cname = cname;
        this.cnum = cnum;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }
}
