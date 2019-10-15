package com.sia.java.practise.test_practise;

import java.io.*;

public class Practise5 {
    public static void main(String[] args) throws FileNotFoundException {
//        System.out.println(sumFloat(1.3F,2.5F,3.5F));
//        System.out.println(isEvenNum(4));
//        System.out.println(jointString("aasda","adawd"));
//        System.out.println(isPrimeNumber(13));
//        System.out.println(isPrimeNumber(15));
//        System.out.println( firstLetterToUpper("it is a letter") );
        System.out.println( changeNum ("2F",16) );
//        System.out.println(numchange( 10,2));
//        calcRestNum(98,67);
        // 数组更换
//        int[] a = {1,2,3,4,5};
//        int[] b = {11,12,13,14,15};
//        int[] temp1 = new int[1];
//        int[] temp2 = new int[a.length-1];
//        int tempIndex = -1;
//        for (int i=0;i<5;i++){
//            if (a[i]==5){
//            temp1[0]=a[i];
//            tempIndex = i;
//            break;
//            }
//        }
//        for ( int i=0;i<a.length-1; i++) {
//            if( i<tempIndex ) temp2[i] = a[i];
//            else  temp2[i] = a[i+1];
//        }
//        a = temp2;
//        int[] temp3 = new int[b.length+1];
//        for (int i=0; i<b.length+1; i++) {
//            if ( i==b.length ) temp3[i] = temp1[0];
//            else temp3[i] = b[i];
//        }
//        b = temp3;
//        for ( int ff:b ) System.out.print( ff + "  ");

//        try{
//            File homework = new File("C:\\Users\\Administrator\\Desktop\\周末作业.txt");
//            InputStream readText = new FileInputStream(homework);
//            byte[] buf = new byte[(int)homework.length()];
//            readText.read(buf);
//            readText.close();
//            for ( byte b:buf ) System.out.print( b + "  " );
//        }
//        catch ( IOException m) {
//            m.printStackTrace();
//        }
//        try{
//            File homework = new File("C:\\Users\\Administrator\\Desktop\\周末作业.txt");
//            OutputStream out = new FileOutputStream(homework,true);
//            String content = "\r\n这是我他妈的用代码写入文件内\r\n";
//            byte[] buf = content.getBytes();
//            out.write(buf,0,buf.length);
//            out.close();
//        }
//        catch ( IOException m) {
//            m.printStackTrace();
//        }
//        System.out.println();
//        try{
//            File homework = new File("C:\\Users\\Administrator\\Desktop\\周末作业.txt");
//            InputStream readText = new FileInputStream(homework);
//            InputStreamReader reader = new InputStreamReader(readText, StandardCharsets.UTF_8);
//            int temp;
//            while ( (temp = reader.read()) !=-1) {
//                if (((char)temp) !='\r') {
//                    System.out.print((char)temp);
//                }
//            }
//            reader.close();
//        }
//        catch ( IOException m) {
//            m.printStackTrace();
//        }
    }


    public static float sumFloat ( float a,float b,float c ) {
        return a+b+c;
    }

    public static boolean isEvenNum(int a) {
        return a % 2 == 0;
    }

    public  String jointString(String str1, String str2) {
        return str1+str2;
    }

    public  String isPrimeNumber(int num) {
        int count = 0;
        for ( int i=2; i*i<=num; i++ ) if ( num%i==0 ) count++;
        return count==0?"是质数":"不是质数";
    }

    public static String firstLetterToUpper(String str) {
        int index = -1;
        char[] chars = str.toCharArray();
        for (int i=0; i<str.length(); i++) {
            index = str.indexOf(" ",index+1);
            if ( index!=-1 ) str = (char)( ((int)chars[0])-32 )+str.substring(1,index+1) + (char)( ((int)chars[index+1])-32) + str.substring(index+2,chars.length);
        }
        return str;
    }
    public static int changeNum ( String strNumber,int n ) {
        char[] c = strNumber.toCharArray();        // 转换为字符串，用于计算数字的长度
        int result=0;
        for( int i=0; i<c.length; i++) {
            int b;
            b = ( c[i]>=48 && c[i]<=57 ) ?  c[i]-48 : ( c[i]>=55 && c[i]<=70 ) ? ( c[i]-55 ) : ( c[i]-87 );
            int a = 1;        // 用于在接下去的for循环计算所在次数的基数for ( int j=0; j<c.length-1-i; j++) a*=n;
            for ( int j=0; j<c.length-1-i; j++) a*=n;           //用来算出每位的16的多少次方
            result += a*b;    // 得到结果
        }
        return result;

    }
    public static int numchange( int num,int n) {
        String str = "";
        while ( num>0 ) {
            int temp = num%n;
            str = (temp<=9?temp+"":(char)(temp+55)) + str;
            num/=n;
        }
        return Integer.parseInt(str);
    }
    public static void calcRestNum(int a,int b) {
        while ( b>0 ) {
            int restNum = a%b;
            a = b;
            b = restNum;
        }
        System.out.println(a);
    }



}