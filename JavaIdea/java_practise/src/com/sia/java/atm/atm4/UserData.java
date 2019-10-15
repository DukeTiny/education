package com.sia.java.atm.atm4;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    static List<UserData> userInfo = new ArrayList<UserData>() ;
    private String userId;
    private String uName;
    private String uPwd;
    private double balance;

    static{
        UserData ud1 = new UserData();
        ud1.setUserId("02100653");
        ud1.setuName("王虎");
        ud1.setuPwd("hawanghuha");
        ud1.setBalance(5000.00);
        userInfo.add(ud1);
        UserData ud2 = new UserData ("02100654","马丁","hawanghuha",5000D);
        userInfo.add(ud2);
    }

    public static int checkAccount(String str) {
        int findIndex = -1;
        for ( int i=0; i<userInfo.size(); i++) {
            if ( userInfo.get(i).getuName().equals(str)) {
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    public boolean checkPwd( int accountIndex,String logPwd) {
        return userInfo.get(accountIndex).getuPwd().equals(logPwd);
    }

    public void addNewUser (String username,String password) {
        String lastUserId = userInfo.get( userInfo.size() -1).getUserId();
        String newAccountId = String.valueOf ( Integer.parseInt(lastUserId) + 1 );
        userInfo.add( new UserData( newAccountId,username,password,5000D ) );
    }

    public UserData() {

    }

    public UserData (String id, String name, String pwd, double f) {
        this.userId = id;
        this.uName = name;
        this.uPwd = pwd;
        this.balance = f;
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


}
