package com.sia.java.atm.atm4;

import java.util.Scanner;

public class Atmfunction {


    private Scanner input = new Scanner(System.in);


    public boolean storeMoney() {
        int accountIndex = UserManagement.myIndex;
        System.out.println("请输入您要存入的金额。");
        System.out.println(accountIndex);
        double deposit = input.nextDouble();
        if ( inputMoneyRight( deposit ) ){
            UserData.userInfo.get(accountIndex).setBalance(UserData.userInfo.get(accountIndex).getBalance()+deposit);
            System.out.println( "您现在的余额为：" + UserData.userInfo.get(accountIndex).getBalance() );
            System.out.println("存款成功");
        }
        else storeMoney();
        return true;
    }
    public boolean withdraw() {
        int accountIndex = UserManagement.myIndex;
        System.out.println("请输入您要取出的金额。");
        double withdrawal = input.nextDouble();
        if ( inputMoneyRight( withdrawal ) && withdrawal<=UserData.userInfo.get(accountIndex).getBalance() ){
            UserData.userInfo.get(accountIndex).setBalance(UserData.userInfo.get(accountIndex).getBalance()-withdrawal);
            System.out.println("取款成功");
            System.out.println( "您现在的余额为：" + UserData.userInfo.get(accountIndex).getBalance() );
        }
        else {
            System.out.println("余额不足，请重新输入");
            withdraw();
        }
        return true;
    }

    public void query() {
        int accountIndex = UserManagement.myIndex;
        System.out.println("您的余额为：" +  UserData.userInfo.get(accountIndex).getBalance() );
    }

    public boolean transfer() {
        int accountIndex = UserManagement.myIndex;
        System.out.println("请输入您要转账的用户的用户名。");
        String toAccount = input.next();
        int toAccountIndex = UserData.checkAccount( toAccount );
        if ( toAccountIndex==-1 ) {
            System.out.println("您输入的的账户不存在。");
            transfer();
        }

        while ( true ) {
            System.out.println("请输入您要转账的金额。");
            double transferMoney = input.nextDouble();
            if ( inputMoneyRight ( transferMoney ) && transferMoney<=UserData.userInfo.get(accountIndex).getBalance() ) {
                UserData.userInfo.get(accountIndex).setBalance(UserData.userInfo.get(accountIndex).getBalance()-transferMoney);
                UserData.userInfo.get(toAccountIndex).setBalance(UserData.userInfo.get(toAccountIndex).getBalance()+transferMoney);
                System.out.println("转账成功");
                break;
            }
            else System.out.println("余额不足，无法转账，请重新输入");
        }
        return true;
    }

    public boolean cancelAccount() {
        int accountIndex = UserManagement.myIndex;
        System.out.println("您确定要注销您的账户？");
        System.out.println("1.确定  2.取消");
        String choice = input.nextLine();
        if ( choice.equals("1") ){
            UserData.userInfo.remove(accountIndex);
            System.out.println("账户注销成功");
            return true;
        }
        return false;

    }
    public boolean inputMoneyRight( double inputMoney ){
        boolean flag = true;
        if ( inputMoney<=0 ){
            System.out.println("您输入的的金额有误,请重新输入。");
            flag = false;
        }
        return flag;
    }

}
