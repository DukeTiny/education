package com.sia.java.atm.atm3;

import java.util.Scanner;

public class AtmFunction {

    static int index = -1;
    Scanner enter = new Scanner(System.in);
    ArrList uInfo = new ArrList();

    public void login() {
        UI.inputUidUi();
        System.out.println("请输入您的用户名");
        String idStr = enter.next();
        int loginIndex = checkAccount( idStr );
        index = loginIndex;
        if ( loginIndex==-1 ) {
            System.out.println ("用户名输入错误，请重新输入。");
            login();
        }

        System.out.println("|---------Please Enter Your Password---------|");
        String pwdStr = enter.next();
        if ( uInfo.userInfo.get(loginIndex).getuPwd().equals(pwdStr) ){
            System.out.println("登陆成功");
            UI.successfulUi();
            Choice.logChoice();
        }
        else {
            System.out.println("密码输入错误，请重新登陆");
            this.login();
        }
    }

    public void register() {

        System.out.println("请输入您的用户名");
        String username = enter.next();
        int regIndex = checkAccount( username );
        if ( regIndex==-1 ) {
            System.out.println("请输入您的密码");
            String password = enter.next();
            String tempUserId = uInfo.userInfo.get(uInfo.userInfo.size() - 1).getUserId();
            tempUserId = String.valueOf(Integer.parseInt(tempUserId) + 1);
            uInfo.userInfo.add(new UserData(tempUserId,username,password,5000D));

            System.out.println("注册成功,请登陆");
            this.login();
        }
    }

    public void saveMoney(){
        
        System.out.println("请输入您要存入的金额");
        double addMoney = enter.nextDouble();
        uInfo.userInfo.get(index).setBalance(uInfo.userInfo.get(index).getBalance()+addMoney);
        System.out.println("存款成功");
        
    }

    public void withDrawMoney() {

        System.out.println("请输入您要取出的金额");
        double reduceMoney = enter.nextDouble();
        if ( reduceMoney<=uInfo.userInfo.get(index).getBalance()) {
            uInfo.userInfo.get(index).setBalance(uInfo.userInfo.get(index).getBalance()-reduceMoney);
            System.out.println("取款成功");
            UI.backOrOutUi();
            Choice.continueOperate();
        }
        else {
            System.out.println("余额不足，请重新输入。");
            withDrawMoney();
        }
    }

    public void transferMoney() {

        System.out.println("请输入您要转账的用户姓名");
        String tempStr = enter.next();
        int toIndex = checkAccount ( tempStr );
        while ( true ) {
            if ( toIndex != -1 ){
                System.out.println("请输入您要转账的金额");
                double transferMoney = enter.nextDouble();
                if( transferMoney <= ArrList.userInfo.get(index).getBalance() ) {
                    ArrList.userInfo.get(index).setBalance( ArrList.userInfo.get(index).getBalance() - transferMoney );
                    ArrList.userInfo.get(toIndex).setBalance( ArrList.userInfo.get(toIndex).getBalance() + transferMoney );
                    System.out.println(ArrList.userInfo.get(toIndex).getBalance());
                    System.out.println("转账成功");
                    break;
                }
                else System.out.println("余额不足，请重新输入");
            }
        }
    }

    public void checkMoney() {
        System.out.println("您的余额为" + ArrList.userInfo.get(index).getBalance());
        UI.backOrOutUi();
        Choice.continueOperate();
    }
    public void cancelAccout() {
        System.out.println("您确定要注销账户么？");
        System.out.println("1.确定  2.取消");
        int choice = enter.nextInt();
        switch ( choice ) {
            case 1: ArrList.userInfo.remove(index);
                break;
            case 2: UI.successfulUi();
                    Choice.logChoice();
                break;
            default: System.out.println("信息输入错误，请重新输入");
                     cancelAccout();
                break;
        }

    }
    public int checkAccount(String name) {
        int index = -1;
        for (int i = 0; i < uInfo.userInfo.size(); i++) {
            if (uInfo.userInfo.get(i).getuName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

}
