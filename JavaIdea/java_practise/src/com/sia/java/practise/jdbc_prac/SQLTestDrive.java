package com.sia.java.practise.jdbc_prac;

import com.sia.java.practise.jdbc_prac.bean.ClassInfo;
import com.sia.java.practise.jdbc_prac.util.ClassDao;
import com.sia.java.practise.jdbc_prac.util.ClassDao2;
import com.sia.java.practise.jdbc_prac.util.ClassDao3;
import com.sia.java.practise.jdbc_prac.util.ClassDao4;

import java.util.ArrayList;

public class SQLTestDrive {
    public static void main(String[] args) {
        ClassDao4 cd = new ClassDao4();
//        cd.del( 106 );
        cd.add( new ClassInfo(106,"Class 106",0));
//        cd.change( new ClassInfo(106,"Class 10006",10));
//        ClassInfo ci = cd.getSingle(106);
//        System.out.println(ci.getCid()+","+ci.getCname()+","+ci.getCnum());
        ArrayList<ClassInfo> al = cd.getAll();
        for ( ClassInfo c:al ){
            System.out.println(c.getCid()+","+c.getCname()+","+c.getCnum());
        }
    }
}
