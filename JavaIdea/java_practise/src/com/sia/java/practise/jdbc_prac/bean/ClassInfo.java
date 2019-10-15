package com.sia.java.practise.jdbc_prac.bean;

public class ClassInfo {
    int a;
    String s;
    private int cid;
    private String cname;
    private int cnum;

    public ClassInfo() {
    }

    public ClassInfo(int cid, String cname, int cnum) {
        this.cid = cid;
        this.cname = cname;
        this.cnum = cnum;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }
}
