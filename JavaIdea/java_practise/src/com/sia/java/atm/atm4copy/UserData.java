package com.sia.java.atm.atm4copy;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    static List<UserData> userInfo = new ArrayList<UserData>() ;
    private String userId;
    private String uName;
    private String uPwd;
    private double balance;
    static UserData user;

//    static{
//        UserData ud1 = new UserData();
//        ud1.setUserId("02100653");
//        ud1.setuName("王虎");
//        ud1.setuPwd("hawanghuha");
//        ud1.setBalance(5000.00);
//        userInfo.add(ud1);
//        UserData ud2 = new UserData("02100654","马丁","hawanghuha",5000D);
//        userInfo.add(ud2);
//    }

    public UserData checkAccount ( String username ) {
        for ( int i=0; i<userInfo.size(); i++) {
            if ( userInfo.get(i).getuName().equals( username ) ) {
                return userInfo.get(i);
            }
        }
        return null;
    }
    public UserData checkAccount ( String username,String pwd ) {
        for ( int i=0; i<userInfo.size(); i++) {
            if ( userInfo.get(i).getuName().equals( username ) && userInfo.get(i).getuPwd().equals( pwd )) {
                this.user = userInfo.get(i);
                return userInfo.get(i);
            }
        }
        return null;
    }


    public boolean addNewUser ( String username,String password ) {
        for ( int i=0; i<userInfo.size(); i++)
            if ( username.equals(userInfo.get(i).getuName()) ) return false;
        if( userInfo.size()>0 ){
            String lastUserId = userInfo.get( userInfo.size() -1).getUserId();
            String newAccountId = String.valueOf ( Integer.parseInt(lastUserId) + 1 );
            userInfo.add( new UserData( newAccountId,username,password,5000D ) );
        }
        else {
            String newAccountId = "02100653";
            userInfo.add( new UserData( newAccountId,username,password,5000D ) );
        }
        return true;
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
