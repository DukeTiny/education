package com.sia.java.atm.atm3;


import java.util.ArrayList;

import java.util.List;

public class ArrList {

    static List<UserData> userInfo = new ArrayList<UserData>();
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

}
