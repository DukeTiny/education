package com.sia.java.practise.classarray.atmui;

import com.sia.java.practise.classarray.atmfunction.Atmfunction;
import com.sia.java.practise.classarray.atmuserdata.UserData;

public class AtmUI {

    public static void main(String[] args) {

        UserData userData = new UserData();
        userData.userName = "王虎";
        userData.userPwd = "329087464";
        userData.userRestMoney = 5000;
        Atmfunction atmFunction = new Atmfunction();
        atmFunction.addUser ( userData );

        UserData userData1 = new UserData();
        userData1.userName = "马丁";
        userData1.userPwd = "02100653";
        userData1.userRestMoney = 5000;
        atmFunction.addUser ( userData1 );

        atmFunction.transfer("王虎","马丁",1234);

        atmFunction.readUserData();


    }
}
