package com.sia.java.atm.atm6;

import java.io.IOException;
import java.util.Scanner;

public class UI {

    Scanner input = new Scanner(System.in);
    UserManagement um = new UserManagement();
    Atmfunction atmfunction = new Atmfunction();
    ReadAndWrite rw = new ReadAndWrite();

    public static void main(String[] args) throws IOException {
        UI ui = new UI();
        ui.firstPage();
    }

    public void firstPage() {

        System.out.println("*******欢迎光临本虚拟银行测试系统********");
        System.out.println("*******       1.登    陆       *******");
        System.out.println("*******       2.注    册       *******");
        System.out.println("*******欢迎光临本虚拟银行测试系统********");

        String choice = input.nextLine();
//        try {
            switch (choice) {
                case "1":
                    while ( !um.login() ){}
                    secondPage();
                    break;
                case "2":
                    if ( um.register() ) firstPage();
                    break;
                default: firstPage();
            }
//        }
//        catch (Exception e){
//            System.out.println("您输入的的信息有误。");
//            firstPage();
//        }
    }

    public void secondPage() {
        System.out.println("*******欢迎光临本虚拟银行测试系统*******");
        System.out.println("*******       1.存    款       *******");
        System.out.println("*******       2.取    款       *******");
        System.out.println("*******       3.查    询       *******");
        System.out.println("*******       4.转    账       *******");
        System.out.println("*******       5.注    销       *******");
        System.out.println("*******       6.退    出       *******");
        System.out.println("*******欢迎光临本虚拟银行测试系统********");

        String choice = input.nextLine();
//        try {
            switch (choice) {
                case "1":
                    atmfunction.storeMoney();
                    secondPage();
                    break;
                case "2":
                    if (atmfunction.withdraw() ) {
                        secondPage();
                    }
                    break;
                case "3":
                    atmfunction.query();
                    secondPage();
                    break;
                case "4":
                    if ( atmfunction.transfer() ){
                        secondPage();
                    }

                    break;
                case "5":
                    if ( atmfunction.cancelAccount() ){
                        UserManagement.userData  = null;
                        firstPage();
                    }
                    else secondPage();
                    break;
                case "6":
                    UserManagement.userData = null;
                    firstPage();
                    break;
                default: secondPage();
            }
//        }
//        catch (Exception e){
//            System.out.println("您输入的的信息有误,请重新输入。");
//            secondPage();
//        }
    }

}
