package com.sia.java.basic;

import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
//      changeToBinary();
//      inputNumber();
//      tellLength();
//      nineTimesNine();
//        avoidSeven();
        outPutDoubleTrangle();
    }

    public static void inputNumber() {
        System.out.println("请输入一个数字");
        Scanner enter = new Scanner(System.in);
        while ( true ){
            int num = enter.nextInt();
            if ( num == 0 ) break;
            System.out.println(num);
        }
    }
    public static void tellLength() {
        System.out.println("请输入一个");
        Scanner enter = new Scanner(System.in);
        Long num = enter.nextLong();
        int count = 0;
        while ( num!=0 ){
            count++;
            num/=10;
        }
        System.out.println(count);
    }

    public static void changeToBinary(){
        int num=10, times=1, result=0;
        while ( num!=0 ) {
            result = result +  times*(num%2);
            times*=10;
            num/=2;
        }
        System.out.println(result);
    }
    public static void nineTimesNine() {
        for ( int i=1; i<=9; i++) {
            for ( int j=1; j<=i; j++){
                if ( i==j ) System.out.println( j+"*" + i + "="+ i*j+"\t");
                else System.out.print(j+"*" + i + "="+ i*j + "\t");
            }
        }
    }
    public static void avoidSeven() {
        for ( int i=0; i<=100; i++) {
            if ( i%10==7 || i%7==0 || i/10==7) {
                System.out.print( "00"+"\t" );
                continue;
            }
            else if ( i==69 ) System.out.println(i);
            else {
                if ( i % 10 == 0 ) {
                    System.out.println();
                    System.out.print(i +"\t");
                }
                else System.out.print(i + "\t");
            }
        }
    }

    public static void outPutDoubleTrangle() {
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                if (j > 7 - i && j < 7 + i ) {
                    System.out.print("0");
                    System.out.print("   ");
                } else System.out.print("  ");

            }
            System.out.println();
        }
        for (int i = 7; i >= 1; i--) {
            System.out.print("  ");
            for (int j = 2; j <= 7; j++) {
                if (j < 8 + i && j > 8 - i) {
                    System.out.print("0");
                    System.out.print("   ");

                } else System.out.print("  ");

            }
            System.out.println();
        }
    }
}

