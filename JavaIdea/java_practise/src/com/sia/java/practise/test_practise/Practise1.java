package com.sia.java.practise.test_practise;

import java.util.Scanner;

public class Practise1 {
    public static void main(String[] args) {
        Practise1 run = new Practise1();
//        run.dateCount();
//        run.sortNumber();
//        run.randomNumberArray();
//        String str = run.extractString("ABCDEFGAWEQ",4);
//        System.out.println(str);
        char result = run.getChar("adawdqdawq",0);
        System.out.println(result);
    }


    private void dateCount() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入第几个月");
        int month = enter.nextInt();
        System.out.println("请输入这个月的第多少天");
        int day = enter.nextInt();
        int date = 0;
        switch (month) {
            case 12:
                date += 30;
            case 11:
                date += 31;
            case 10:
                date += 30;
            case 9:
                date += 31;
            case 8:
                date += 31;
            case 7:
                date += 30;
            case 6:
                date += 31;
            case 5:
                date += 30;
            case 4:
                date += 31;
            case 3:
                date += 28;
            case 2:
                date += 31;
            case 1:
                date += day;
                System.out.println("您输入的的是一年中的第" + date + "天");
                break;
            default:
                System.out.println("输入信息错误");
                break;
        }
    }

    private void sortNumber() {
        int[] array = {12, 10, 23, 8, 35};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int num : array) {
            System.out.println(num);
        }
    }

    public void randomNumberArray() {
        int[] numArray = new int[20];
        for (int i = 0; i < 20; i++) {
            numArray[i] = (int) (Math.random() * 20);
            System.out.print(numArray[i] + "  ");
        }
        int[][] testArray = new int[5][];
        testArray[3] = new int[]{};
        testArray[3][1] = 5;
        System.out.println(testArray[3][1]);
    }

    public String extractString(String a, int index) {
        String temp = "";
        for (int i = index; i < a.length(); i++) {
            temp += a.valueOf(i);
        }
        return temp;
    }
    public void findString(String str,String cutStr) {
        int count = 0;
        int index = 0;
        while ( true ) {
            index = str.indexOf(cutStr,index);
            if ( index == -1 ) break;
            else { count++; index++; }
        }
        System.out.println(count);
    }
    public char[]  strToCharArray( String str ) {
        char[] result = new char[str.length()];
        for ( int i=0; i<result.length; i++) {
            char tempChar = str.charAt(i);
            result[i] = tempChar;
        }
        return result;
    }
    public char getChar (String str,int index) {
        char[] tempChar =  strToCharArray(str);
        return tempChar[index];
    }
    public char getCode (String str,int index) {
        char[] tempChar = new char[str.length()];
        for ( int i=0; i<tempChar.length; i++){
            tempChar[i] = strToCharArray(str)[i];
        }
        return tempChar[index];
    }

}
