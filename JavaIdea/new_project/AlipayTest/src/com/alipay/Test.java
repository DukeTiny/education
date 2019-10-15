package com.alipay;


import java.io.*;

public class Test {

    private static Integer tn;

    public static void main(String[] args) throws IOException {
        get(5);
    }

    private static void doubleNum(int n) {
        System.out.println(n);
        if(n<=5000)
            doubleNum(n*2);
        System.out.println(n);
    }

    private static void get ( int n ) {
        int[] s = new int[n];
        if ( tn==null ) tn = n;
        StringBuilder sb = new StringBuilder();
        sb.append( tn ).append("=").append(--n);
//        for( int i = 1; i<=n/2 ; i++ ){
//            for( int j=1; j<=i; j++ ) {
//
//            }
//        }
        int count =0;
        for( int i=1;i<tn-n; i++ ) {
            sb.append("+").append(1);
            if( tn-n >1 && n>tn/2 ){
                if ( count!=0 ) continue;
                StringBuilder sb2 = new StringBuilder();
                sb2.append( tn ).append("=").append(n);
                int sum = 0;
                sb2.append("+");
                for( int j=1; j<=tn-n; j++ ) {
                    sum += 1;
                }
                sb2.append(sum);
                System.out.println(sb2.toString());
                count++;
            }
        }
        if( n>1 ){
            get( n );
        }
        System.out.println(sb.toString());

    }

}

