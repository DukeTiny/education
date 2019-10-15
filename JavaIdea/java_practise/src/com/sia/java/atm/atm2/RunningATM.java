package com.sia.java.atm.atm2;


public class RunningATM {

    static String[] users = {"Duke_Tiny","Slayy521","Iamacoward"};
    static String[] passes = {"hawanghuha","lujunchen","ihopenot"};
    static double[] balance = {500.00D,500.00D,500.00D};
    static int index = -1;

    public static void main(String[] args) {
        ApplicationInterface start = new ApplicationInterface();
        start.startPageInterface();
        UserChoice choose = new UserChoice();
        choose.startChoice();
    }
}

