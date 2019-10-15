package 王虎第一周周考;

import java.util.Scanner;

public class Num8 {


    static String[][] usersData = { {"02100653","111111"},{"02100654","222222"}};
    int index = -1;
    Scanner input = new Scanner( System.in );

    public static void main(String[] args) {
        Num8 a = new Num8();
        a.register();
    }

    public void login() {
        System.out.println("请输入您的用户名");
        String userId = input.next();
        for ( int i=0; i<usersData.length; i++) {
            if ( usersData[i][0].equals(userId)) {
                index = i;
                break;
            }
        }
        if ( index!=-1 ){
            System.out.println("请输入您的密码");
            String userPwd = input.next();
            if ( usersData[index][1].equals(userPwd))
                System.out.println("登陆成功");
            else {
                System.out.println("密码错误,请重新登录");
                login();
            }
        }
        else {
            System.out.println("用户名不存在，请重新输入");
            login();
        }
    }

    public void register() {
        System.out.println("请如您的用户名");
        String newUser = input.next();
        System.out.println("请输入您的密码");
        String newPwd = input.next();
        String[][] tempArray = new String[usersData.length+1][2];
        for ( int i=0; i<usersData.length; i++ ) {
            tempArray[i][0] = usersData[i][0];
            tempArray[i][1] = usersData[i][1];
        }
        tempArray[usersData.length][0] = newUser;
        tempArray[usersData.length][1] = newPwd;
        usersData = tempArray;
        System.out.println("注册成功，欢迎使用本银行。");
        login();
    }
}
