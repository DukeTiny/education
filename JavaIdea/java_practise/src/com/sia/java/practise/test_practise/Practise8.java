package com.sia.java.practise.test_practise;

import java.util.*;

public class Practise8 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("姓名","王虎");
        hashMap.put("身高","163cm");
        System.out.println( hashMap.get("姓名") );
        Set hmSet = hashMap.keySet();
        System.out.println(hashMap);
        for ( Object o : hmSet ) {
            System.out.print(  o + "：");
            System.out.println(hashMap.get(o));
        }
        Iterator i = hmSet.iterator();
        while ( i.hasNext() ){
            String ss = (String)i.next();
        }
        String a = hashMap.toString();
        System.out.println(a);

        ArrayList arrList = new ArrayList();
        arrList.add("abc");
        arrList.add("bbb");
        System.out.println(arrList);
        String b = arrList.toString();
        System.out.println(b);
        int[] c = {1,2,3,4,5};
        String d = Arrays.toString(c);
        System.out.println(d);

    }

}