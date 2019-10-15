package com.cxz.po;

import java.util.Date;

public class UserLogin {

    private Integer roleId;
    private Integer id;
    private String account;
    private String password;
    private Date updateTime;
    private Date createTime;
    private Integer status;

    public UserLogin() {}

    public UserLogin(Integer roleId, Integer id, String account, String password, Date updateTime, Date createTime, Integer status) {
        this.roleId = roleId;
        this.id = id;
        this.account = account;
        this.password = password;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.status = status;
    }

    public void setRoleId (Integer integer) {
        this.roleId = integer;
    }

    public Integer getRoleId(){
        return this.roleId;
    }

    public void setId (Integer integer) {
        this.id = integer;
    }

    public Integer getId(){
        return this.id;
    }

    public void setAccount (String string) {
        this.account = string;
    }

    public String getAccount(){
        return this.account;
    }

    public void setPassword (String string) {
        this.password = string;
    }

    public String getPassword(){
        return this.password;
    }

        public void setUpdateTime (Date date) {
        this.updateTime = date;
    }

    public Date getUpdateTime(){
        return this.updateTime;
    }

    public void setCreateTime (Date date) { 
        this.createTime = date;
    }

    public Date getCreateTime(){
        return this.createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}