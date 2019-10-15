package com.cxz.bean;

public class UserInformation {

    private Integer userID;
    private String username;
    private String userPWD;
    private String userRole;
    private String userStatus;

    public UserInformation() {}

    public UserInformation(Integer userID, String username, String userPWD, String userRole, String userStatus) {
        this.userID = userID;
        this.username = username;
        this.userPWD = userPWD;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPWD() {
        return userPWD;
    }

    public void setUserPWD(String userPWD) {
        this.userPWD = userPWD;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

}
