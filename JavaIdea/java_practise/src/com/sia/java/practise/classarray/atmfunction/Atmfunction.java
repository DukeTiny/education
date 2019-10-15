package com.sia.java.practise.classarray.atmfunction;

import com.sia.java.practise.classarray.atmuserdata.UserData;

public class Atmfunction {
    UserData[] users = new UserData[10];
    int index = 0;
    public void addUser(UserData user) {
        users[index++] = user;
    }
    public void readUserData() {
        for( int i=0; i<index; i++) {
            System.out.println ( users[i].userName + "  " + users[i].userPwd + "  " + users[i].userRestMoney );
        }
    }
    public void transfer( String fromName,String toName,int money ){
        for (int i=0; i<index; i++ ){
            if ( users[i].userName.equals(fromName)) {
                users[i].userRestMoney -=money;
                break;
            }
        }
        for ( int i=0; i<index;i++ ) {
            if ( users[i].userName.equals(toName) ) {
                users[i].userRestMoney +=money;
                break;
            }
        }
    }
}
