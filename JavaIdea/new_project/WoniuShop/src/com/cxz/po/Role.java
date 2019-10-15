package com.cxz.po;

public class Role {

    private Integer id;
    private String username;
    private Integer status;

    public Role() {}

    public Role(Integer id, String username, Integer status) {
        this.id = id;
        this.username = username;
        this.status = status;
    }

    public void setId (Integer integer) {
        this.id = integer;
    }

    public Integer getId(){
        return this.id;
    }

    public void setUsername (String string) { 
        this.username = string;
    }

    public String getUsername(){
        return this.username;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}