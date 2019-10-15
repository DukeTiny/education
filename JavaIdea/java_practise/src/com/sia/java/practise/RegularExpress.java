package com.sia.java.practise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpress {

    public static void main(String[] args) {
        RegularExpress RE = new RegularExpress();
        RE.match("13621932553");
        RE.find();

    }

    void match ( String phoneNumber ) {
//        String phPattern = "^1[3578]\\d{9}$";
        String phPattern = "^1(3|5|7|8)\\d{7,9}$";
//        Pattern pa = Pattern.compile ( phPattern );
////        Pattern pa1 = Pattern.compile ( phPattern,Pattern.CASE_INSENSITIVE );
//        Matcher mp = pa.matcher(phoneNumber);
//        boolean rightNum = mp.matches();
//        System.out.println( rightNum );
        System.out.println(Pattern.compile(phPattern).matcher(phoneNumber).matches());
    }

    void find() {
        String source = "<input name='verify' value='5AC' type='hidden'  value='5AC8E6D2' type='hidden'/>";
        String regex = "(value=')(.+)( value=')(.+)(' type)";
        Pattern pa = Pattern.compile( regex );
        Matcher m = pa.matcher(source);
        String temp = "";
        if ( m.find() ) temp = m.group(4);
        System.out.println ( temp );
    }


}
