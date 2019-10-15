package com.sia.java.homework.java_before_2019_03_26;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDay28HomeWork {
    public static void main(String[] args) throws ParseException {
//        randomTime();
//        calcBirh1();
//        calcBirh2();
//        dayOfWeek();
//        setCalendar();
//        setDate();
//        changeStyle();
//        reverseStrDate();
//        doubleColor();
//        showCard();
        outputCal();
    }

    public static void randomTime() {
        int month = (int)(Math.random()*11)+1,date,hour,minute,second;
        if ( month==1 || month==3 || month==5 || month ==7 || month==8 || month==10 || month==12)
            date = (int)(Math.random()*30)+1;
        else if ( month==4 || month==6 || month==9 || month==11 )
            date = (int)(Math.random()*29)+1;
        else date = (int)(Math.random()*27)+1;
        hour = (int)(Math.random()*24);
        minute = (int)(Math.random()*60);
        second = (int)(Math.random()*60);
        System.out.println("1995." + month + "." + date + ".  " + hour + ":" + minute + ":" + second);
    }

//    public static void calcBirh1() {
//        Date d1 = new Date();
//        Date d2 = new Date(90,8,19);
//        double second = (double)((d1.getTime()-d2.getTime())/1000);
//        int day = (int)( second/3600/24 );
//        int hour = (int)( (second%(3600*24))/3600);
//        int minute = (int)( (second%(3600*24)%3600)/60 );
//        System.out.println("我已经出生" + day + "天" + hour + "小时" + minute + "分。");
//    }
//    public static void calcBirh2() {
//        Calendar c1 = Calendar.getInstance();
//        c1.set(1990,Calendar.SEPTEMBER,19);
//        Calendar c2 = Calendar.getInstance();
//        double second = (double)( ( c2.getTimeInMillis() - c1.getTimeInMillis() )/1000);
//
//        int day = (int)( second/3600/24 );
//        int hour = (int)( (second%(3600*24))/3600);
//        int minute = (int)( (second%(3600*24)%3600)/60 );
//        System.out.println("我已经出生" + day + "天" + hour + "小时" + minute + "分。");
//    }

    public static void dayOfWeek() {
        Calendar c = Calendar.getInstance();
        c.set(1990,Calendar.SEPTEMBER,19);
        System.out.println("我出生的时候是星期" + (c.get(Calendar.DAY_OF_WEEK)-1));
    }
    public static void setCalendar() {
        Calendar c = Calendar.getInstance();
        c.set(2019,Calendar.MAY,15,12,23,45);
        System.out.println(c.getTime());
    }
    public static void setDate() {
        Calendar c = Calendar.getInstance();
        c.set ( 2019,Calendar.APRIL,19 );
        System.out.println( c.getTime() );
        c.set ( 2018,Calendar.MARCH,19 );
        System.out.println( c.getTime() );
        c.set ( 2019,Calendar.FEBRUARY,4 );
        System.out.println( c.getTime() );
    }
    public static void changeStyle() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String str = sdf.format(date);
        System.out.println(str);
    }
    public static void reverseStrDate() throws ParseException {
        String str = "2019:02:15";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd");
        Date date = sdf.parse(str);
        System.out.println(date);
    }
    public static void doubleColor() {
        int blue = (int)(Math.random()*13)+1;
        int[] red = new int[33];
        for ( int i=0; i<33; i++ ) red[i] = i;
        for ( int i=0; i<6; i++) {
            int num = (int)(Math.random()*(33-i))+1;
            red[num-1] = red[32-i];
            red[32-i]=num;
        }
        System.out.println("蓝色球为" + blue + "号");
        System.out.print("红色号为");
        for ( int i=32; i>26; i--) System.out.print(red[i]+"号,");
    }
    public static void showCard() {
        String[] str = new String[52];
        int k=0;
        for (int i=0; i<4; i++) {   // 0->黑桃  1->红桃  2->方块  3->梅花   11->J 12->Q 13->K 14->A
            for (int j=2; j<15; j++,k++) {
                if ( i==0 ) str[k] = "黑桃"+ j;
                if ( i==1 ) str[k] = "红桃"+ j;
                if ( i==2 ) str[k] = "方块"+ j;
                if ( i==3 ) str[k] = "梅花"+ j;
            }
        }
        for ( int i=0; i<51; i++) {
            int tempNum = (int)((Math.random()*(52-i))+1);
            String tempStr = str[tempNum-1];
            str[tempNum-1] = str[51-i];
            str[51-i] = tempStr;
        }
        System.out.println("底牌为");
        for ( int i=0; i<4; i++) { System.out.print( str[i] + "  "); }
        System.out.println();
        for ( int i=0 ; i<3; i++) {
            System.out.println("玩家"+(i+1) +"号的底牌为：");
            int j=4+i;
            for ( ; j<50+i; j+=3) { System.out.print( str[j] + " "); }
            System.out.println();
        }
    }
    public static void outputCal() {
        for ( int month=1; month<=12; month++) {
            Date d1 = new Date(119,month-1,1);
            System.out.println( month+"月" );
            System.out.println("日"+"\t"+"一"+"\t"+"二"+"\t"+"三"+"\t"+"四"+"\t"+"五"+"\t"+"六"+"\t");
            int a = d1.getDay();
            Date d2;
            if ( month<=11 ) d2 = new Date(119,month,0);
            else d2 = new Date(120,1,0);
            int total = d2.getDate();
            int date = 1;
            for (int j = 0; j < a; j++) System.out.print("\t");
            for (int k = a; k < 7; k++) {
                System.out.print(date + "\t");
                date++;
            }
            for (int i = 1; i < 6; i++) {
                System.out.println();
                for (int j = 0; j < 7 && date<=total; j++) {
                    System.out.print(date + "\t");
                    date++;
                }
            }
            System.out.println();
        }
    }
}


