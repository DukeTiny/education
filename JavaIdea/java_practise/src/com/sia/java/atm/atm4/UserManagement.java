package com.sia.java.atm.atm4;

import java.util.Scanner;

public class UserManagement {

    Scanner input = new Scanner(System.in);
    UserData userData = new UserData();
    static int myIndex = -1;

    /** 登陆功能
     * @return
     */
    public boolean login() {
        // 检查账户是否存在
        System.out.println("请输入您的用户名");
        String logAccount = input.nextLine();
        int accountIndex = userData.checkAccount(logAccount);
        myIndex = accountIndex;
        System.out.println(myIndex);
        if ( accountIndex == -1) {
            System.out.println("用户名不存在，请重新输入。");
            login();
        }
        // 检查密码是否正确
        System.out.println("请输入您的密码");
        String logPwd = input.nextLine();
        if( !userData.checkPwd (accountIndex, logPwd) ) {
            System.out.println("密码或账户错误，请重新登陆。");
            login();
        }
        // 返回布尔，由UI界面中决定是否进入到二级界面
        return true;
    }

    /** 注册功能
     * @return
     */
    public boolean register() {
        // 检查用户名是否存在
        boolean successfulReg = false;
        System.out.println("请输入您要注册的用户名");
        String regAccount = input.nextLine();
        int regIndex = userData.checkAccount(regAccount);
        // 判断是否存在之后进行的操作
        if ( regIndex != -1 ) {
            System.out.println("用户名已存在，请重新输入");
            register();
        }
        // 用户名正确之后，请用户输入密码。
        System.out.println("请输入您的密码。");
        String regPwd = input.nextLine();
        if ( regPwd.length() >= 6 ) {
            userData.addNewUser(regAccount, regPwd);
            System.out.println("注册成功");
            successfulReg = true;
        }
        else {
            System.out.println("密码长度不符合要求，请重新输入。");
        }
        return successfulReg;
    }

}
