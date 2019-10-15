package com.sia.java.homework.java_2019_04_15_synchorized.print_letter_and_bread;

public class Print {
    static int i=1;
    static int j=97;

    public synchronized void printNum() {
        if( i<=52){
            System.out.print(i++ + "  ");
            System.out.print(i++ + "  ");
        }
    }
    public synchronized void printLetter() {
        if ( i%2==1 && j<=122 ){
            System.out.println( (char)j++ + "  ");
        }
    }
}
