package com.sia.java.homework.java_before_2019_03_26;

import java.util.Scanner;


public class JavaDay31HomeWork {

    String[][] students1 = {{"01100653","王虎","男","27","1"}};
    String[][] students2 = {{"02100653","王虎","男","27","2"}};
    String[][] students3 = {{"03100653","王虎","男","27","3"}};

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        JavaDay31HomeWork call = new JavaDay31HomeWork();
//        call.letterChange('c');
//        call.trangle();
//        call.primeNumber();
//        call.calcChicken();
//        call.fullNum();
        call.threeFigures();
//        call.sqrtNum();
    }
    public void letterChange(char letter) {
        int code = (int)letter;
        if ( code >=97 && code<=122 ) {
            char newLetter = (char)(code-32);
            System.out.println( "字符 " + letter + " 是小写字母,转换为大写之后是 " + "\"" + newLetter + "\"。");
        }
        else System.out.println( "字符 " + "\"" + letter + "\"" + " 不是小写字母。");
    }
    public void trangle() {
        System.out.println("请输入第一条边长");         int a = input.nextInt();
        System.out.println("请输入第二条边长");         int b = input.nextInt();
        System.out.println("请输入第三条边长");         int c = input.nextInt();
        System.out.println( ( a+b>c && a+c>b && b+c>a )?"您输入的三条边长可以构成一个三角形":"您输入的的三条边长无法构成一个三角形");
    }
    public void primeNumber() {
        for ( int i=200; i<=500; i++){
            int count = 0;
            for ( int j=2; j<i; j++)  if ( i%j==0 ) count++;
            if ( count==0 ) System.out.println( i + " 是素数");
        }
    }

    public void calcChicken() {
        System.out.println("总共有以下买法");
        int count = 0;
        for ( int i=0; i<=20; i++)
            for ( int j=0; j<=50; j++)
                for ( int k=0; k<=99; k++)
                    if ( i + j + k == 100  &&  5 * i + 3 * j + k / 3 == 100 && k%3==0) {
                        System.out.println("公鸡" + i +"只，母鸡" + j + "只，雏鸡" + k + "只。");
                        count++;
                    }
        System.out.println("总共有" + count + "种买法");
    }

    public void fullNum() {
        for ( int i=2; i<10000; i++) {
            int sum = 0;
            for( int j=1; j<i; j++) {
                if ( i%j==0 ) sum+=j;
            }
            if ( i==sum ) System.out.println( i + "是完全数");
        }
    }

    public void threeFigures() {
        int count = 0;
        for( int i=1; i<=4; i++)
            for ( int j=1; j<=4; j++)
                for ( int k=1; k<=4; k++){
                    if ( i!=j && i!=k && j!=k ) {
                        System.out.println("三位数有" + ( i*100 + j*10 + k) );
                        count++;
                    }
                }
        System.out.println("总共有" + count + "个不重复的三位数");
    }
    public void sqrtNum() {
           // n^2-(n-1)^2 <=168. a+100>=0 >>> 可算出 n<=84.5,就是算出相邻两个整数的平方差大于168 a>=-100;
        int count = 0;
        for ( int a = -100; a<85*85-268; a++)                            // 计算出a的范围
            for ( int i=1; i*i<=a+100; i++)                  // a+100的开方等于i,因为开方之后的数只能为正数，所以i>=0,我写了1开始，从题知道0不可能。
                for ( int k=1; k*k<=a+268; k++)              // a+100+168的开方等于k,k的范围同i的范围取法
                    if ( i*i == a+100 && k*k == a+268) {     // 同事满足的时候
                        System.out.println("这个数是" + a);
                        count++;
                    }
        System.out.println(count);
    }

    public static void enterSchool() {

    }





}
