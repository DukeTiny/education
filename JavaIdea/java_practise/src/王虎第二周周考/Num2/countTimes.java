package 王虎第二周周考.Num2;

import java.util.*;

public class countTimes {


    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        System.out.println("请输入一串字符串");
        String str = input.nextLine();

        HashSet hs = new HashSet();
        HashMap hm = new HashMap();
        for ( int i=0; i<str.length(); i++ ) {
            int oldSize = hs.size();
            hs.add(str.charAt(i));
            if ( hs.size()>oldSize ) hm.put( str.charAt(i),1 );
            else hm.put( str.charAt(i),(int)hm.get( str.charAt(i))+1 );
        }
        System.out.println(hm.size());
        Set hmSet = hm.keySet();
        Iterator ihm = hmSet.iterator();
        while ( ihm.hasNext() ) {
            char c = (char)ihm.next();
            System.out.println( c + ":" + hm.get(c) );
        }

    }
}
