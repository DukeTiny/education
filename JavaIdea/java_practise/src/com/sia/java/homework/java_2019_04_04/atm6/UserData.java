package com.sia.java.homework.java_2019_04_04.atm6;

public class UserData {

    private String userId;
    private String uName;
    private String uPwd;
    private double balance;
    private double index;

    public UserData() {}

    public UserData (String id, String name, String pwd, double f) {
        this.userId = id;
        this.uName = name;
        this.uPwd = pwd;
        this.balance = f;
    }

    public double getIndex() {
        return index;
    }

    public void setIndex(double index) {
        this.index = index;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return this.getUserId() + ReadAndWrite.OPRATOR + this.getuName() + ReadAndWrite.OPRATOR + this.getuPwd() + ReadAndWrite.OPRATOR + this.getBalance();
    }

}
