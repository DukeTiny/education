package com.sia.java.atm.atm2;

public class ApplicationInterface {

    public void startPageInterface() {
        System.out.println("-------------------请输入您需要的操作----------------");
        System.out.println("|                                                |");
        System.out.println("|               1.登陆   2.注册   3.退出           |");
        System.out.println("|                                                |");
        System.out.println("--------------------------------------------------");
    }
    public void afterRegistInterface(){
        System.out.println("-------------------请输入您需要的操作----------------");
        System.out.println("|												 |");
        System.out.println("|                1.登陆        2.返回   	         |");
        System.out.println("|												 |");
        System.out.println("--------------------------------------------------");
    }
    public void afterLoginInterface(){
        System.out.println("-------------------请输入您需要的操作----------------");
        System.out.println("|                                                 |");
        System.out.println("| 1.存款   2.取款   3.转账   4.查询余额   5.退出系统   |");
        System.out.println("|                                                 |");
        System.out.println("---------------------------------------------------");
    }
    public void afterCashWork() {
        System.out.println("-------------------请输入您需要的操作-----------------");
        System.out.println("|                                                 |");
        System.out.println("|                 1.继续操作   2.退出系统            |");
        System.out.println("|                                                 |");
        System.out.println("---------------------------------------------------");
    }
}
