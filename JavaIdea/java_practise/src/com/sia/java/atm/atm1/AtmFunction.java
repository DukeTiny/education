package com.sia.java.atm.atm1;

import java.util.Scanner;

public class AtmFunction {
    static String[] users = {"Duke_Tiny","Slayy521","Iamacoward"};
    static String[] passes = {"hawanghuha","lujunchen","ihopenot"};
    static double[] balance = {500.00D,500.00D,500.00D};
    static int index = 0;
    public static void main(String[] args) {
        AtmFunction start = new AtmFunction();
        start.startedPage();
    }
    public void startedPage() {

        System.out.println("-------------------请输入您需要的操作----------------");
        System.out.println("|                                                |");
        System.out.println("|               1.登陆   2.注册   3.退出           |");
        System.out.println("|                                                |");
        System.out.println("--------------------------------------------------");

        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您的选择");
        String choice = enter.next();
        switch (choice) {
            case "1": this.login();
                break;
            case "2": this.regist();
                break;
            case "3": System.exit(0);
                break;
            default:
                System.out.println("您输入的信息有误；请重新输入。");
                this.startedPage();
        }
        enter.close();
    }

    public void login() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您的用户名");
        String inputUsername = enter.next();
        boolean isUserOk = false;
        for ( int i=0; i<users.length; i++ ){
            if( inputUsername.equals(users[i]) ) {
                isUserOk = true;
                index = i;
                break;
            }
        }
        if ( !isUserOk ) {
            System.out.println("用户名输入错误,请重新输入");
            this.login();
        }
        System.out.println("请输入您的密码");
        String inputPassword = enter.next();
        if ( inputPassword.equals(passes[index])) {
            System.out.println("登陆成功");
            this.afterLogin();
        }
        else {
            System.out.println("您输入的的密码错误");
            this.login();
        }
    }

    public void regist() {

        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您要注册的用户名");
        String username = enter.next();
        // 检查账户是否存在
        for ( String i: users ){
            if ( username.equals(i)){
                System.out.println("您的用户名已存在");
                this.regist();
            }
        }
        System.out.println("请输入您的密码");
        String password = enter.next();
        this.addAccount( username,password );

        System.out.println("注册成功");
        System.out.println("-------------------请输入您需要的操作----------------");
        System.out.println("|												 |");
        System.out.println("|                1.登陆        2.返回   	         |");
        System.out.println("|												 |");
        System.out.println("--------------------------------------------------");

        String choice = enter.next();
        switch(choice) {
            case "1" : this.login();
                break;
            case "2": this.startedPage();
                break;
            default :  this.startedPage();
                break;
        }
        enter.close();

    }

    public void afterLogin() {
        System.out.println("--------------------请输入您需要的操作-----------------");
        System.out.println("|                                                  |");
        System.out.println("|1.存款 2.取款 3.转账 4.查询余额 5.销卡 6.改密 7.退出系统 |");
        System.out.println("|                                                  |");
        System.out.println("----------------------------------------------------");

        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您的选项");
        int choice = enter.nextInt();
        switch ( choice ) {
            case 1:changeBalance( choice );
                break;
            case 2:changeBalance( choice );
                break;
            case 3:transferMoney();
                break;
            case 4:
                System.out.println("您的余额为："+balance[index]);
                afterLogin();
                break;
            case 5:
                cancelAccount();
                break;
            case 6:
                changePassword();
                break;
            case 7:
                System.out.println("系统已退出");
                System.exit(0);
                break;
            default:
                System.out.println("输入信息错误，请重新输入");
                this.afterLogin();
        }
    }

    public void addAccount( String username,String password ){
        String[] tempUser = new String[ users.length+1 ];
        String[] tempPass = new String[ passes.length+1 ];
        double[] tempBalance = new double[ balance.length+1 ];
        for ( int i=0; i<users.length; i++) {
            tempUser[i] = users[i];
            tempPass[i] = passes[i];
            tempBalance[i] = balance[i];
        }
        tempUser[ users.length] = username;
        tempPass[ passes.length] = password;
        tempBalance[ balance.length] = 500.00D;

        users = tempUser;
        passes = tempPass;
        balance = tempBalance;
    }

    public void changeBalance(int choice) {
        switch ( choice ) {
            case 1:
                System.out.println("请输入您要存入的金额");
                Scanner enterA = new Scanner(System.in);
                int addMoney = enterA.nextInt();
                balance[index] = balance[index] + addMoney;
                System.out.println("存款成功");
                System.out.println("-------------------请输入您需要的操作----------------");
                System.out.println("|                                                |");
                System.out.println("|                 1.继续操作   2.退出系统           |");
                System.out.println("|                                                |");
                System.out.println("--------------------------------------------------");
                System.out.println("请选择你要进行的操作");
                int optionA = enterA.nextInt();
                boolean inputA = true;
                while (inputA) {
                    switch ( optionA ) {
                        case 1:
                            this.afterLogin();
                            inputA = false;
                            break;
                        case 2:
                            System.exit(0);
                            inputA = false;
                            break;
                        default:
                            System.out.println("输入错误，请重新输入");
                            optionA = enterA.nextInt();
                    }
                }
            case 2:
                System.out.println("请输入您要取出的金额");
                Scanner enterB = new Scanner(System.in);
                int reduceMoney = enterB.nextInt();
                balance[index] = balance[index] - reduceMoney;
                System.out.println("取款成功");
                System.out.println("-------------------请输入您需要的操作----------------");
                System.out.println("|                                                |");
                System.out.println("|                 1.继续操作   2.退出系统           |");
                System.out.println("|                                                |");
                System.out.println("--------------------------------------------------");
                System.out.println("请选择你要进行的操作");
                int optionB = enterB.nextInt();
                boolean inputB = true;
                while (inputB) {
                    switch (optionB) {
                        case 1:
                            this.afterLogin();
                            inputB = false;
                            break;
                        case 2:
                            System.exit(0);
                            inputB = false;
                            break;
                        default:
                            System.out.println("输入错误，重新输入");
                            optionB = enterB.nextInt();
                    }
                }
        }
    }

    public void cancelAccount () {
        Scanner enter = new Scanner(System.in);
        System.out.println("您确定要注销账户？");
        System.out.println("1.确定   2。取消");
        int choice = enter.nextInt();
        if ( choice==1 ){
            users[index] = users[users.length-1];
            passes[index] = passes[passes.length-1];
            balance[index] = balance[balance.length-1];
            String[] usersTemp = new String[users.length-1];
            String[] passesTemp = new String[passes.length-1];
            double[] balanceTemp = new double[balance.length-1];

            for ( int i=0; i<users.length-1;i++) {
                usersTemp[i] = users[i];
                passesTemp[i] = passes[i];
                balanceTemp[i] = balance[i];
            }
            users = usersTemp;
            passes = passesTemp;
            balance = balanceTemp;
            System.out.println("账户注销成功,系统即将退出");
            startedPage();
        }
        if ( choice==2 ) this.afterLogin();
        else {
            System.out.println("信息输入错误，请重新选择");
            cancelAccount();
        }
    }

    public  void changePassword() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您要修改的密码");
        String tempPass1 = enter.next();
        System.out.println("请再次输入您要修改的密码");
        String tempPass2 = enter.next();
        if ( tempPass1.equals(tempPass2) ) {
            passes[index] = tempPass2;
            System.out.println("修改密码成功,请重新登陆");
            startedPage();
        }
        else {
            System.out.println("两次输入密码不一样，请重新输入。");
            changePassword();
        }
        enter.close();
    }

    public void transferMoney() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入您要转账的账户");
        String tempUser = enter.next();
        boolean successTransfer = false;
        for ( int i=0; i<users.length; i++) {
            if( tempUser.equals(users[i]) ){
                System.out.println("请输入您要转出的金额");
                int tempMoney = enter.nextInt();
                balance[index] -=tempMoney;
                balance[i]+=tempMoney;
                System.out.println("转账成功");
                boolean selectRight = false;

                while ( !selectRight ) {
                    System.out.println("-------------------请输入您需要的操作----------------");
                    System.out.println("|                                                |");
                    System.out.println("|                 1.继续操作   2.退出系统           |");
                    System.out.println("|                                                |");
                    System.out.println("--------------------------------------------------");
                    System.out.println("请选择你要进行的操作");
                    int choice = enter.nextInt();
                    if ( choice==1 ) {
                        selectRight = true;
                        successTransfer = true;
                        afterLogin();
                        break;
                    }
                    else if( choice==2 ){
                        System.out.println("系统已退出");
                        System.exit(0);
                    }
                    else {
                        System.out.println("输入错误，请重新输入");
                    }
                }
                break;
            }
        }
        if( !successTransfer ) {
            System.out.println("转账账户不存在，请重新输入。");
            transferMoney();
        }
    }

}

