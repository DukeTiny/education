package com.sia.java.practise;

public class MyException extends RuntimeException {
    private String myStr;

    public MyException(String str) {
        System.out.println(str);
        myStr = str;
    }
    @Override
    public void printStackTrace(){
        System.out.println("aaa");
    }
    @Override
    public String getMessage(){
        System.out.println(this.myStr);
        return this.myStr;
    }

}
