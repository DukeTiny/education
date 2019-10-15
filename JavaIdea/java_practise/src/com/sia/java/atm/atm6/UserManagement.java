package com.sia.java.atm.atm6;

import java.util.Scanner;

public class UserManagement {

    Scanner input = new Scanner(System.in);
    static UserData userData = null;
    ReadAndWrite rw = new ReadAndWrite();

    /** 登陆功能
     * @return
     */
    public boolean login() {
        System.out.println("请输入您的用户名");
        userData = new UserData();
        userData.setuName( input.nextLine() );
        userData = rw.extract ( userData );
        if ( userData.getUserId()== null ) {
            System.out.println("用户名错误。");
            return false;
        }
        System.out.println("请输入您的密码");
        String pwd = input.nextLine();
        if ( userData.getuPwd().equals( pwd ) ){
            return true;
        }
        else {
            System.out.println("密码错误。请重新输入。");
            rw.update( userData );
            userData = null;
        }
        return false;
    }


    /* 注册功能 */
    public boolean register() {
        // 检查用户名是否存在
        System.out.println("请输入您要注册的用户名");
        UserData tempUser = new UserData();
        tempUser.setuName( input.nextLine() );
        tempUser = rw.extract( tempUser );
        if ( tempUser.getUserId()==null ){
            System.out.println("请输入您的密码。");
            tempUser.setuPwd( input.nextLine() );
        }
        else  return false;
        rw.addNewUser( tempUser );
        return true;
    }
}
