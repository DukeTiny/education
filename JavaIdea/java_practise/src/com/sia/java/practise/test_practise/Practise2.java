package com.sia.java.practise.test_practise;

import java.util.Scanner;

public class Practise2 {
    public static void main(String[] args) {
//        changeToUpperCase();
//        judgeLetter();
//        addCode();
//        changeToUpper();
//        changeLetter1();
//        changeLetter2();
//        delSpace();
        countTimes();
    }

    public static void changeToUpperCase() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输如一堆小写字母");
        String enterString = enter.next();
        System.out.println(enterString.toUpperCase());
        enter.close();
    }
    public static void judgeLetter() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输如第1串字符串");
        String str1 = enter.next();
        System.out.println("请输如第2串字符串");
        String str2 = enter.next();
        System.out.println("请输如第3串字符串");
        String str3 = enter.next();
        System.out.println("请输如第4串字符串");
        String str4 = enter.next();
        System.out.println("请输如第5串字符串");
        String str5 = enter.next();
        boolean itIsTrue1 = str1.startsWith("abc");
        boolean itIsTrue2 = str2.startsWith("abc");
        boolean itIsTrue3 = str3.startsWith("abc");
        boolean itIsTrue4 = str4.startsWith("abc");
        boolean itIsTrue5 = str5.startsWith("abc");
        System.out.println("第1串是否以\"abc\"开头？" + itIsTrue1);
        System.out.println("第2串是否以\"abc\"开头？" + itIsTrue2);
        System.out.println("第3串是否以\"abc\"开头？" + itIsTrue3);
        System.out.println("第4串是否以\"abc\"开头？" + itIsTrue4);
        System.out.println("第5串是否以\"abc\"开头？" + itIsTrue5);
        enter.close();
    }
    public static void addCode() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入一串字符串");
        String str = enter.next();
        byte[] bytesArray = str.getBytes();
        char[] charArray = new char[str.length()];
        for ( int i=0; i<str.length();i++) {
            bytesArray[i] = (byte)(bytesArray[i] + 5);
            charArray[i] = (char)bytesArray[i];
            System.out.print(charArray[i]);
        }
    }


    public static void countTimes() {
        String str = "asd qweqwgw asd qweqwewq asd qweqwe asd";
        int count = 0;
//        int length = str.length();
//        int index = str.lastIndexOf("asd",length-1);
        int index = str.lastIndexOf("asd",str.length()-1);
        while ( true ) {
            if ( index!=-1) {
                count++;
                index = str.lastIndexOf("asd",index-"asd".length());
            }
            else break;
        }
        System.out.println(count);
    }

}
