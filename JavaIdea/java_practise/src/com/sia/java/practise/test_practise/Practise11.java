package com.sia.java.practise.test_practise;
import com.sia.java.practise.MyException;

import java.util.Scanner;

public abstract class Practise11 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        try {
            if (str.equals("test")) {
                throw new MyException("说明我猜想是正确的");
            }
        }
        catch(MyException my){
                my.getMessage();
                my.printStackTrace();
            }
    }

}