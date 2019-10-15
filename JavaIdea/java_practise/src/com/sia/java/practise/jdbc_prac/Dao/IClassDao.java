package com.sia.java.practise.jdbc_prac.Dao;

import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.util.ArrayList;

public interface IClassDao {
    void add( ClassInfo ci );
    void del( int cid );
    void change( ClassInfo ci  );
    ClassInfo getSingle(int cid );
    ArrayList<ClassInfo> getAll() throws ClassNotFoundException;
}
