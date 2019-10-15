package com.sia.java.atm.atm4copy;

import java.util.Scanner;

public class Atmfunction {

    private Scanner input = new Scanner(System.in);
    UserData userData = new UserData();

    public static void main(String[] args) {

    }
    public boolean storeMoney() {
        System.out.println("请输入您要存入的金额。");
        double deposit = input.nextDouble();

        if ( inputMoneyRight ( deposit ) ){
            System.out.println(UserData.user.getBalance());
            UserData.user.setBalance ( UserData.user.getBalance()+deposit );
            System.out.println( "您现在的余额为：" + UserData.user.getBalance() );
            System.out.println("存款成功");
        }
        else storeMoney();
        return true;
    }
    public boolean withdraw() {
        System.out.println("请输入您要取出的金额。");
        double withdrawal = input.nextDouble();
        if ( inputMoneyRight( withdrawal ) && withdrawal<= UserData.user.getBalance() ){
            UserData.user.setBalance ( UserData.user.getBalance()-withdrawal );
            System.out.println("取款成功");
            System.out.println( "您现在的余额为：" + UserData.user.getBalance() );
        }
        else {
            System.out.println("余额不足，请重新输入");
            withdraw();
        }
        return true;
    }

    public void query() {
        System.out.println ( "您的余额为：" +  UserData.user.getBalance() );
    }

    public boolean transfer() {
        System.out.println("请输入您要转账的用户的用户名。");
        String toAccount = input.next();
        UserData toUser = userData.checkAccount ( toAccount );
        if ( toUser == null ) {
            System.out.println("您输入的的账户不存在。");
            this.transfer();
        }

        while ( true ) {
            System.out.println("请输入您要转账的金额。");
            double transferMoney = input.nextDouble();
            if ( inputMoneyRight ( transferMoney ) && transferMoney<= UserData.user.getBalance() ) {
                UserData.user.setBalance ( UserData.user.getBalance()-transferMoney );
                toUser.setBalance ( toUser.getBalance()+transferMoney );
                System.out.println("转账成功");
                break;
            }
            else System.out.println("余额不足，无法转账，请重新输入");
        }
        return true;
    }

    public boolean cancelAccount() {
        System.out.println("您确定要注销您的账户？");
        System.out.println("1.确定  2.取消");
        String choice = input.nextLine();

        if ( choice.equals("1") ){
            UserData.userInfo.remove(UserData.user);
            System.out.println("账户注销成功");
            return true;
        }
        return false;
    }

    public boolean inputMoneyRight ( double inputMoney ){
        if ( inputMoney<=0 ){
            System.out.println("您输入的的金额有误,请重新输入。");
            return false;
        }
        return true;
    }

}
