package com.cxz;

import java.util.HashSet;
import java.util.Set;

public class Test {

    private static Set<String> result;

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("abc");
        sortStr( set );
        System.out.println(result.size());
        for ( String str : result ){
            System.out.println(str);
        }
    }

    private static void sortStr( Set<String> set ) {
        if( result==null ) result = new HashSet<>(set);
        int inCount = set.size();
        Set<String> tempSet = new HashSet<>(set);
        for ( String s : tempSet ) {
            char c = s.charAt(0);
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(0);
            for( int i=0 ; i<sb.length(); i++ ){
                sb.insert(i+1,c);
                set.add(sb.toString());
                result.add(sb.toString());
                sb.deleteCharAt(i+1);
            }
        }
        int outCount = set.size();
        if( inCount!=outCount ) sortStr(set);
    }

}
