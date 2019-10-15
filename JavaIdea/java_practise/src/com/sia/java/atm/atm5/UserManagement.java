package com.sia.java.atm.atm5;

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
        if ( userData.getUserId() == null ) {
            System.out.println("用户名错误。");
        }
        System.out.println("请输入您的密码");
        String pwd = input.nextLine();
        if ( userData.getuPwd().equals( pwd ) ){
            return true;
        }
        else {
            System.out.println("密码错误。请重新输入。");
            rw.appendToFile( userData );
            userData = null;
        }
        return false;
    }
//    public boolean doRight() {
//        if ( this.login() ) {
//            System.out.println("登陆成功。");
//            return true;
//        }
//        else {
//            this.login();
//            return false;
//        }
//    }

    /** 注册功能
     * @return
     */
    public boolean register() {
        // 检查用户名是否存在
        System.out.println("请输入您要注册的用户名");
        UserData tempUser = new UserData();
        String newName = input.nextLine();
        tempUser.setuName( newName );
        UserData temp = rw.extract ( tempUser );
        if ( temp.equals( tempUser ) ){
            System.out.println("请输入您的密码。");
            String pwd = input.nextLine();
            tempUser.setuPwd( pwd );
            tempUser.setUserId( "0" + ( Integer.parseInt(ReadAndWrite.getStrs()[0]) +1 ));
            tempUser.setBalance( 5000.00 );
        }
        else  return false;
        rw.appendToFile( tempUser );
        return true;
    }

}
