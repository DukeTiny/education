package com.sia.java.practise.test_practise;


import java.io.*;

public class Practise7 {
    private static Object OutputStream;
    private static int abc;

    public Practise7(){
    }

    public static void main(String[] args) throws IOException {

//        int x = 0;
//        while ( x<4 ){
//            System.out.print("a");
//            if ( x<1 ) System.out.print(" ");
//            System.out.print("n");
//            if( x<1 ) {
//                System.out.print("oise");
//                x-=1;
//            }
//            if ( x==1 ) System.out.print("noys");
//            if ( x>1 ) System.out.print(" oyster");
//            System.out.println();
//            x+=2;
//        }
//        int x = 0;
//        while ( x<4 ){
//            System.out.print("a");
//            if ( x<1 ) System.out.print(" ");
//            System.out.print("n");
//            if( x<1 ) {
//                System.out.print("oise");
//                x+=2;
//            }
//            if ( x==1 ) System.out.print("noys");
//            if ( x>1 ) System.out.print(" oyster");
//            System.out.println();
//            x+=1;
//        }
//        System.out.println("################");
//        File file = new File("D:\\Test.txt");
//        OutputStream os = new FileOutputStream(file,true);
//        OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
//        String s = "This is a test";
//        char[] c = s.toCharArray();
//        osw.write(c,0,c.length);
//        osw.flush();
//        osw.close();
//
//        String str = "ccbcbbaa";
//        HashSet set = new HashSet();
//        for ( int i=0; i<str.length(); i++) {
//            char c = str.charAt(i);
//            set.add(c);
//        }
//        Iterator it = set.iterator();
//        while ( it.hasNext() ){
//            System.out.println(it.next());
//        }


    }

    public String[] extentArray(String[] str) {
        String[] tempStr = new String[str.length+1];
        for ( int i=0; i<str.length; i++ ) {
            tempStr[i] = str[i];
        }
        tempStr[str.length] = "ABC";
        str = tempStr;
        return str;
    }

}