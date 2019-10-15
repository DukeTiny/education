package com.sia.java.atm.atm2;

import java.util.Scanner;

public class UserChoice {

    public void startChoice() {
        ApplicationInterface ai = new ApplicationInterface();
        Scanner enter = new Scanner(System.in);
        AtmFunction af = new AtmFunction();
        System.out.println("请输入您的选择");
        String choice = enter.next();
        switch (choice) {
            case "1": af.login();
                break;
            case "2": af.regist();
                break;
            case "3": System.exit(0);
                break;
            default:
                System.out.println("您输入的信息有误；请重新输入。");
                ai.startPageInterface();
        }
        enter.close();
    }
    public void cashChoice() {
        AtmFunction af = new AtmFunction();
        System.out.println("请选择你要进行的操作");
        Scanner enter = new Scanner(System.in);
        int option = enter.nextInt();
        boolean input = true;
        while (input) {
            switch ( option ) {
                case 1:
                    af.afterLogin();
                    input = false;
                    break;
                case 2:
                    System.out.println("系统已退出");
                    System.exit(0);
                    input = false;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    option = enter.nextInt();
            }
        }
    }
}
