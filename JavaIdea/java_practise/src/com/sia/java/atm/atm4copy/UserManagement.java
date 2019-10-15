package com.sia.java.atm.atm4copy;

import java.io.File;
import java.util.Scanner;

public class UserManagement {

    Scanner input = new Scanner(System.in);
    UserData userData = new UserData();
    File file = new File("D:/Sia/JavaIdea/src/com/sia/java/atm4copy/usersInfo.txt");

    /** 登陆功能
     * @return
     */
    public boolean login() {
        // 检查账户是否存在
        System.out.println("请输入您的用户名");
        String logAccount = input.nextLine();
        System.out.println("请输入您的密码");
        String logPwd = input.nextLine();
        UserData fromUD  = userData.checkAccount(logAccount,logPwd);
        if ( fromUD == null ) {
            System.out.println("用户名或密码错误。");
            this.login();
        }
        return true;
    }

    /** 注册功能
     * @return
     */
    public boolean register() {
        // 检查用户名是否存在
        System.out.println("请输入您要注册的用户名");
        String regAccount = input.nextLine();
        System.out.println("请输入您的密码。");
        String regPwd = input.nextLine();

        if ( userData.addNewUser ( regAccount,regPwd ) )
            System.out.println("注册成功");
        else {
            System.out.println("用户名已经存在，请重新输入。");
            this.register();
        }

        return true;
    }

}
