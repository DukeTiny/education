package com.sia.java.atm.atm2;

import java.util.Scanner;

public class AtmFunction {

    ApplicationInterface start = new ApplicationInterface();
    UserChoice choices = new UserChoice();


    public void login() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您的用户名");
        String inputUsername = enter.next();
        boolean isUserOk = false;
        for (int i = 0; i< RunningATM.users.length; i++ ){
            if( inputUsername.equals(RunningATM.users[i]) ) {
                isUserOk = true;
                RunningATM.index = i;
                break;
            }
        }
        if ( !isUserOk ) {
            System.out.println("用户名输入错误,请重新输入");
            this.login();
        }
        System.out.println("请输入您的密码");
        String inputPassword = enter.next();
        if ( inputPassword.equals(RunningATM.passes[RunningATM.index])) {
            System.out.println("登陆成功");
            this.afterLogin();
        }
        else {
            System.out.println("您输入的的密码错误");
            this.login();
        }
    }
    public void regist() {
        ApplicationInterface ai = new ApplicationInterface();
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名");
        String username = enter.next();
        for ( String i: RunningATM.users){
            if ( username.equals(i)){
                System.out.println("您的用户名已存在");
                this.regist();
            }
        }
        System.out.println("请输入您的密码");
        String password = enter.next();
        this.addAccount( username,password );

        System.out.println("注册成功");
        ai.afterRegistInterface();
        //---------------------
        String choice = enter.next();
        switch(choice) {
            case "1" : this.login();
                break;
            case "2":  start.startPageInterface();
                break;
            default :  start.startPageInterface();
                break;
        }
        enter.close();
    }
    public void addAccount( String username,String password ){
        String[] tempUser = new String[ RunningATM.users.length+1 ];
        String[] tempPass = new String[ RunningATM.passes.length+1 ];
        double[] tempBalance = new double[ RunningATM.balance.length+1 ];
        for (int i = 0; i< RunningATM.users.length; i++) {
            tempUser[i] = RunningATM.users[i];
            tempPass[i] = RunningATM.passes[i];
            tempBalance[i] = RunningATM.balance[i];
        }
        tempUser[ RunningATM.users.length ] = username;
        tempPass[ RunningATM.passes.length ] = password;
        tempBalance[ RunningATM.balance.length ] = 500.00D;

        RunningATM.users = tempUser;
        RunningATM.passes = tempPass;
        RunningATM.balance = tempBalance;
    }
    public void afterLogin() {
        ApplicationInterface ai = new ApplicationInterface();
        ai.afterLoginInterface();
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您的选项");
        int choice = enter.nextInt();
        switch ( choice ) {
            case 1:changeBalance( choice );
                break;
            case 2:changeBalance( choice );
                break;
            case 3:changeBalance( choice-1 );
                break;
            case 4:
                System.out.println("您的余额为："+ RunningATM.balance[RunningATM.index]);
                this.afterLogin();
                break;
            case 5:
                System.out.println("系统已退出");
                System.exit(0);
                break;
            default:
                System.out.println("输入信息错误，请重新输入");
                this.afterLogin();
        }
    }

    public void changeBalance(int choice) {
        ApplicationInterface ai = new ApplicationInterface();
        Scanner enter = new Scanner(System.in);
        switch ( choice ) {
            case 1:
                System.out.println("请输入您要存入的金额");
                int addMoney = enter.nextInt();
                RunningATM.balance[RunningATM.index] += addMoney;
                System.out.println("存款成功");
                ai.afterCashWork();
                choices.cashChoice();

            case 2:
                System.out.println("请输入您要取出的金额");
                int reduceMoney = enter.nextInt();
                RunningATM.balance[RunningATM.index] -= reduceMoney;
                System.out.println("取款成功");
                ai.afterCashWork();
                choices.cashChoice();
        }
    }
}
