package com.cxz.domain;

public class User_Role_Key {

    private Integer uid;
    private Integer rid;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "User_Role_Key{" +
                "uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}
