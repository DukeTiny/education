package com.sia.java.homework.java_before_2019_03_26;

public class JavaDay25HomeWork {
    public static void main(String[] args){
//        char m = 'a';
//        for ( char m = 'a'; m<'c'; m++ ){
//            System.out.println(m);
//        }
        char c='a';
        int code = (int)c;
        code-=32;
        c = (char) code;
        for( int i=1; i<=26;i++ ){
            System.out.print(c+"  ");
            code = (int)c;
            code+=1;
            c = (char) code;
        }

//
//        String c = "a";
//        int code = (int)c.charAt(0);
//        System.out.println(code);
    }

}
