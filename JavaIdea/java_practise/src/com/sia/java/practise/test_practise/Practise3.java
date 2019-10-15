package com.sia.java.practise.test_practise;

import java.util.Date;
import java.util.Scanner;

public class Practise3 {
    public static void main(String[] args) {
//        doMath1();
//        doMath2();
//        doMath3();
//        doMath4();
//        doMath5();
//        doMath6();
//        showHand();
//        gambling();
        calcDays();

    }

    public static void doMath1() {
        long result = (long)Math.pow(5,20);
        System.out.println(result);
    }
    public static void doMath2(){
        int result = (int)(Math.pow(4,3)*Math.pow(5,6));
        System.out.println(result);
    }
    public static void doMath3() {
        for (long i = 1; i<=10; i++) {
            System.out.println((long)Math.pow(i,i));
        }
    }
    public static void doMath4() {
        System.out.println((int)(Math.random()*100));
    }
    public static void doMath5() {
        System.out.println(((int)(Math.random()*14)+1)*7);
    }
    public static void doMath6() {
        int[] numArray = new int[10];
        for ( int i=1; i<=10; i++) {
            numArray[i-1] = (int)(Math.random()*101);
            System.out.println(numArray[i-1]);
        }
    }

    public static void showHand() {
        Scanner enter = new Scanner(System.in);
        boolean doNotWantExit = true;
        while ( doNotWantExit ) {
            System.out.println("请输入石头剪刀布(如想退出，请输入\"退出\")");
            String showHand = enter.next();
            int num = (int)(Math.random()*3);          //0->石头  1->剪刀  2->布
            if ( num ==0 && showHand.equals("石头") )System.out.println("平手");
            if ( num ==0 && showHand.equals("剪刀") )System.out.println("您输了");
            if ( num ==0 && showHand.equals("布") )System.out.println("您赢了");

            if ( num ==1 && showHand.equals("石头") )System.out.println("您赢了");
            if ( num ==1 && showHand.equals("剪刀") )System.out.println("平手");
            if ( num ==1 && showHand.equals("布") )System.out.println("您输了");

            if ( num ==2 && showHand.equals("石头") )System.out.println("您输了");
            if ( num ==2 && showHand.equals("剪刀") )System.out.println("您赢了");
            if ( num ==2 && showHand.equals("布") ) System.out.println("平手");

            if ( showHand.equals("退出")) doNotWantExit = false;
        }
        enter.close();
    }

    public static void gambling() {
        Scanner enter = new Scanner(System.in);
        boolean doNotWantExit = true;
        int money = 1000;
        while ( money>=0 && doNotWantExit ) {
            System.out.println("1、押大  2、押小");
            int choice = enter.nextInt();
            System.out.println("你要压的金额");
            int gamblingMoney = enter.nextInt();
            int num1 = (int) ( Math.random()*6 )+1;
            int num2 = (int) ( Math.random()*6 )+1;
            int num3 = (int) ( Math.random()*6 )+1;
            if ( gamblingMoney>money ) {
                System.out.println("您的余额不足,请重新选择。");
                continue;
            }
            if ( choice==1 && num1+num2+num3>11 ) {
                money += gamblingMoney;
                System.out.println("您赢了，您的金额为：" + money);
            }
            if ( choice==1 && num1+num2+num3<=11 ) {
                money -= gamblingMoney;
                System.out.println("您输了，您的金额为：" + money);
            }
            if ( choice==2 && num1+num2+num3>11 ) {
                money -= gamblingMoney;
                System.out.println("您输了，您的金额为：" + money);
            }
            if ( choice==2 && num1+num2+num3<=11 ) {
                money += gamblingMoney;
                System.out.println("您输了，您的金额为：" + money);
            }
            if( money == 0 ) doNotWantExit = false;
        }
    }

    public static void calcDays() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入年份。");
        int year = enter.nextInt();
        System.out.println("请输入月份。");
        int month = enter.nextInt();
        Date day1 = new Date(year-1900,month-1,0);
        Date day2 = new Date(year-1900,month,0);
        int day = (int)((day2.getTime()-day1.getTime())/1000/60/60/24);
        System.out.println( "您输入的" + year + "年" + month + "月有" + day + "天" );
    }



}