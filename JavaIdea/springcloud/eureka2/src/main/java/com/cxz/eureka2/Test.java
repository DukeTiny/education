package com.cxz.eureka2;

public class Test {

    public static void main(String[] args) {


    }

    private static int test() {
        int a = 10;
        try {
//            StringBuffer sb = null;
//            sb.append("a");
            a = 15;
            return a;
        } catch ( Exception e ){
            System.out.println(1);
            a = 20 ;
//            return a;
            throw new RuntimeException();
        } finally {
            System.out.println(2);
            a = 25;
//            return a;
        }

    }

}
