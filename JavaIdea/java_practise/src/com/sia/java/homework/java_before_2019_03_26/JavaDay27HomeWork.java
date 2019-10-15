package com.sia.java.homework.java_before_2019_03_26;

import java.util.Scanner;

public class JavaDay27HomeWork {
    public static void main(String[] args){

//        inputNumberToArray();                     // 1.声明数组长度，输入数字赋值，正倒叙输出。
//        inputAndSort();                           // 2.输入数组并排序
//        changeToUpperCase();                      // 4.小写字母改大写
//        judgeABC();                               // 5.判断abc开头
//        secretCode();                            // 6.加密输出
//        changeToUpper();                          // 7.jdk改变加截取
//        changeLetter1();                          // 8.改变test为tset
//        changeLetter2();                          // 8.改变test为tset
//        changeLetter3();                          // 8.改变test为tset
//        delSpace();                               // 9.删除字符串终端空格
//        countLetters();                           // 10.各种东西计数
//        removeDuplicates();                       // 11.去掉重复的
    }

    public static void inputNumberToArray() {
        Scanner enter = new Scanner(System.in);
        int[] numArray = new int[8];
        for ( int i=0; i<8; i++) {
            System.out.println("请输入一个数字");
            numArray[i] = enter.nextInt();
        }
        enter.close();
        for ( int a:numArray ) System.out.println("正序输出为" + a + "  " );
        for ( int i=7; i>=0; i--) System.out.println("倒叙输出为" + numArray[i]);
    }
    public static void inputAndSort() {
        Scanner enter = new Scanner(System.in);
        int[] array = new int[8];
        for ( int i=0; i<8; i++) {
            System.out.println("请输入数字");
            array[i] = enter.nextInt();
        }
        enter.close();
        for ( int i=0; i<7; i++) {
            for ( int j=i+1; j<8; j++) {
                if ( array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println(array[i]);
        }
    }
    public static void changeToUpperCase() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入一段字母");
        String letters = enter.next();
        letters = letters.toUpperCase();
        System.out.println(letters);
    }

    public static void judgeABC() {
        Scanner enter = new Scanner(System.in);
        for ( int i=1; i<=5; i++ ) {
            System.out.println("请输入一个字符串");
            String str = enter.next();
            if ( str.startsWith("abc")) System.out.println("是否为=以\"abc\"开头?" + "   是的！");
            else System.out.println("是否为=以\"abc\"开头?" + "   不是的！");
        }
    }
    public static void secretCode() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = enter.next();
        char[] charArray = str.toCharArray();
        for ( int i=0; i<str.length();i++) {
            charArray[i] = (char) ( ( (int)charArray[i] ) + 1 );
        }
        System.out.println(charArray);
    }

    public static void changeToUpper() {
        String str = "jdk";
        str = str.toUpperCase();
        System.out.println("jdk的大写为" + str);
        String subStr = str.substring(1);
        System.out.println("JDK截取的为" + subStr);
    }

    public static void changeLetter1() {
        String str = "test";
        System.out.println(str.substring(0,1) + "se" + str.substring(3,4));
    }
    public static void changeLetter2() {
        String str = "test";
        String temp = str.replace("e",".");
        str = temp.replace("s","e");
        str = str.replace(".","s");
        System.out.println(str);
    }
    public static void changeLetter3() {
        String str = "test";
        char[] charArray = str.toCharArray();
        for (int i=charArray.length-1; i>=0; i--) {
            System.out.println( charArray[i] );
        }
    }

    public static void delSpace() {
        Scanner enter = new Scanner(System.in);
        System.out.println("请输入带空格的字符串");
        String spaceStr = enter.nextLine();
        while (true) {
            int index = spaceStr.indexOf(" ");
            if( index == -1) break;
            else spaceStr = spaceStr.substring(0,index) + spaceStr.substring(index+1);
        }
        System.out.println(spaceStr);
    }

    public static void countLetters() {
        Scanner check = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String aString = check.next();
        byte[] change = aString.getBytes();
        byte upperLetters=0, lowerLetters=0, numbers=0, opreas=0;
        for ( int i=0; i<change.length; i++) {
            int code = (int)change[i];
            if (code >= 48 && code <= 57) numbers++;
            else if (code >= 65 && code <= 90) upperLetters++;
            else if (code >= 97 && code <= 122) lowerLetters++;
            else opreas++;
        }
        System.out.println("大写字母" + upperLetters);
        System.out.println("小写字母" + lowerLetters);
        System.out.println("数字" + numbers);
        System.out.println("符号" + opreas);
        check.close();
    }

    public static void removeDuplicates() {
        Scanner enter = new Scanner (System.in);
        System.out.print("请输入一行字符串：");
        String str = enter.nextLine();
        char tempChar=' ';
        for ( int i=0; i<str.length()-1; i++) {
            int count=0;
            for (int j=i+1; j<str.length(); j++) {
                char[] array = str.toCharArray();
                count++;
                tempChar = array[i];
                if ( str.indexOf(array[i])!=str.lastIndexOf(array[i]) ) {
                    int index = str.lastIndexOf(array[i]);
                    str = str.substring(0,index) + str.substring(index+1,str.length());
                }
                else break;
            }
            System.out.println(tempChar+"的计数为"+count);
        }
        System.out.println(str);
    }

}


