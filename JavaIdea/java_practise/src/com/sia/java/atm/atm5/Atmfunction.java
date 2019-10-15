package com.sia.java.atm.atm5;

import java.util.Scanner;

public class Atmfunction {

    private Scanner input = new Scanner(System.in);
    ReadAndWrite rw = new ReadAndWrite();

    void storeMoney() {
        System.out.println("请输入您要存入的金额。");
        double deposit = input.nextDouble();
        // 存款改金额
        if ( inputMoneyRight ( deposit ) ) {
            UserManagement.userData.setBalance ( UserManagement.userData.getBalance()+deposit );
            System.out.println( "您现在的余额为：" + UserManagement.userData.getBalance() );
            System.out.println("存款成功");
        }
        else storeMoney();
    }

    boolean withdraw() {
        System.out.println("请输入您要取出的金额。");
        double withdrawal = input.nextDouble();
        if ( inputMoneyRight( withdrawal ) && withdrawal <= UserManagement.userData .getBalance() ){
            UserManagement.userData .setBalance ( UserManagement.userData .getBalance() - withdrawal );
            System.out.println("取款成功");
            System.out.println( "您现在的余额为：" + UserManagement.userData .getBalance() );
        }
        else {
            System.out.println("余额不足，请重新输入");
            withdraw();
        }
        return true;
    }

    void query() {
        System.out.println ( "您的余额为：" +  UserManagement.userData.getBalance() );
    }

    public boolean transfer() {
        System.out.println("请输入您要转账的用户的用户名。");
        UserData toUser = new UserData();
        toUser.setuName( input.next() );
        toUser = rw.extract ( toUser );
        if ( toUser == null ) {
            System.out.println("您输入的的账户不存在。");
            this.transfer();
        }

        while ( true ) {
            System.out.println("请输入您要转账的金额。");
            double transferMoney = input.nextDouble();
            if ( inputMoneyRight ( transferMoney ) && transferMoney<= UserManagement.userData.getBalance() ) {
                UserManagement.userData.setBalance ( UserManagement.userData.getBalance()-transferMoney );
                toUser.setBalance ( toUser.getBalance() + transferMoney );
                rw.appendToFile( toUser );
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
        if ( choice.equals("1") ) {
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
