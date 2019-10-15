package com.sia.java.atm.atm3;

import java.util.Scanner;

public class Choice {

    public static void mainUichoice(){
        System.out.println("请输入您的选择");
        Scanner enter = new Scanner ( System.in );
        String choice = enter.next();
        AtmFunction af = new AtmFunction();
        switch ( choice ) {
            case "1": af.login();
                break;
            case "2": af.register();
                break;
            case "3": System.exit(0);
                break;
            default:
                System.out.println("信息输入错误");
                UI.mainUi();
                mainUichoice();
                break;
        }
    }
    public static void logChoice() {
        Scanner enter = new Scanner ( System.in );
        String choice = enter.next();
        AtmFunction af = new AtmFunction();
        switch ( choice ) {
            case "1": af.saveMoney();
                    UI.backOrOutUi();
                    continueOperate();
                break;
            case "2": af.withDrawMoney();
                    UI.backOrOutUi();
                    continueOperate();
                break;
            case "3": af.transferMoney();
                    UI.backOrOutUi();
                    continueOperate();
                break;
            case "4": af.checkMoney();
                    UI.backOrOutUi();
                    continueOperate();
                break;
            case "5": af.cancelAccout();
                    System.out.println("账户注销成功，感谢您对本银行的使用");
                    UI.mainUi();
                    mainUichoice();
                break;
            case "6": System.exit(0);
                break;
            default:
                    System.out.println("输入错误。");
                    UI.successfulUi();
                    logChoice();
                    enter.close();
                break;
        }
    }
    public static void continueOperate() {
        Scanner input = new Scanner( System.in);
        System.out.println("请输入您的选择");
        String choice = input.next();
        switch ( choice ) {
            case "1": UI.successfulUi();
                    logChoice();
                break;
            case "2": System.out.println("系统已经退出");
                    System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重新输入");
                UI.backOrOutUi();
                continueOperate();
        }
    }
}
