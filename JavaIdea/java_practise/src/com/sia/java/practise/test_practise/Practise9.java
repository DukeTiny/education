package com.sia.java.practise.test_practise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

public class Practise9 extends Random{

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        int m=0;
        while ( m<10 )  sb.append(++m + "  ");
        System.out.println(sb);
//        sb.insert(1,"o");
//        System.out.println(sb);
//        sb.delete(3,7);
//        System.out.println(sb);
//        int index = sb.indexOf("2");
//        sb.deleteCharAt(index);
//        System.out.println(sb + "\n\n\n\n\n");
//
//        BigDecimal bd1 = new BigDecimal("0.3");
//        BigDecimal bd2 = new BigDecimal("2");
//        System.out.println( bd1.multiply(bd2) + "乘法");
//        System.out.println( bd1.add(bd2) + "加法");
//        System.out.println( bd1.divide(bd2) + "除法");
//        System.out.println( bd1.subtract(bd2) + "减法");
//        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
//        System.out.println(moneyFormat.format(bd1));
//        NumberFormat perFormat = NumberFormat.getPercentInstance();
//        System.out.println(perFormat.format(bd1));
//
//
        BigDecimal salary = new BigDecimal(8000);
        BigDecimal perc = new BigDecimal("0.13");
        NumberFormat mFormat = NumberFormat.getCurrencyInstance();
        System.out.println(mFormat.format(salary.multiply(perc)));

        BigDecimal sell = new BigDecimal("150000");
        BigDecimal pSell = new BigDecimal("53000");
        NumberFormat sFormat = NumberFormat.getPercentInstance();
        sFormat.setMaximumFractionDigits(2);
//        sFormat.setMaximumIntegerDigits(1);
        System.out.println( sFormat.format ( pSell.divide( sell,4, RoundingMode.HALF_UP ) ) );
        System.out.println( sFormat.format ( pSell.divide( sell,4, BigDecimal.ROUND_HALF_UP ) ) );

        BigDecimal one = new BigDecimal(1);
        BigDecimal three = new BigDecimal(3);
        System.out.println(one.divide(three,3,RoundingMode.HALF_UP));

        Random rd = new Random();
        System.out.println(rd.nextDouble());
        System.out.println(rd.nextInt());
        System.out.println(rd.nextInt(15));
        System.out.println(rd.nextLong() + "\n\n");

        // Num.1
        System.out.println(rd.nextInt(1001)+1000);

        // Num.2
        int[] intArr = new int[10];
        for ( int i=0; i<10;i++ ) {
            intArr[i] = rd.nextInt();
        }
        for ( int i:intArr ) System.out.print(i+"  ");
        System.out.println();

        // Num.3
        int countTrue = 0;
        int countFalse = 0;
        for ( int i=0; i<1000; i++ ) {
            if( rd.nextBoolean() ) countTrue++;
            if( !rd.nextBoolean() ) countFalse++;
        }
        System.out.println( "正确次数为：" + countTrue + "错误的次数为：" + countFalse );

        // Num.4
        HashMap hashMap = new HashMap();
        for ( int i=0; i<10000 ; i++ ) {
            int a = rd.nextInt(10);
            Integer j = (Integer) hashMap.get(a);
            if ( j==null ) hashMap.put(a,1);
            else hashMap.put(a,++j);
        }
        Set hmset = hashMap.keySet();
        for ( Object o:hmset ) System.out.println( o + ":" + hashMap.get(o) );
    }

}