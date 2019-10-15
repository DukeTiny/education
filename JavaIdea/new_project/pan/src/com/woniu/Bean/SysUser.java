package com.woniu.Bean;

import java.util.Date;

public class SysUser {
    private Integer userID;
    private String userLoginName;
    private String userRealName;
    private String userPassword;
    private String userPhone;
    private Date userDate;

    public SysUser() {}

    public SysUser(Integer userID, String userLoginName, String userRealName, String userPassword, String userPhone, Date userDate) {
        this.userID = userID;
        this.userLoginName = userLoginName;
        this.userRealName = userRealName;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userDate = userDate;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getUserDate() {
        return userDate;
    }

    public void setUserDate(Date userDate) {
        this.userDate = userDate;
    }
}
