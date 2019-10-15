package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.jdbc_prac.Dao.IClassDao;
import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.util.ArrayList;

public class ClassDao4 implements IClassDao {
    BaseDAO2<ClassInfo> bd2 = new BaseDAO2();
    @Override
    public void add( ClassInfo ci ) {
        String sql = "INSERT INTO class VALUES(?,?,?)";
        ArrayList al = new ArrayList();
        al.add(ci.getCid()); al.add(ci.getCname()); al.add(ci.getCnum());
        bd2.doSomething(sql,al);
    }

    @Override
    public void del( int c ) {
        String sql = "DELETE FROM class WHERE cid=?";
        ArrayList al = new ArrayList();
        al.add(c);
        bd2.doSomething(sql,al);
    }

    @Override
    public void change( ClassInfo ci  ) {
        String sql = "UPDATE class SET cname=?,cnum=? WHERE cid=?";
        ArrayList al = new ArrayList();
        al.add(ci.getCname());  al.add(ci.getCnum());  al.add(ci.getCid());
        bd2.doSomething(sql,al);
    }

    @Override
    public ClassInfo getSingle(int cid) {
        String sql = "SELECT * FROM class WHERE cid="+cid;
        return bd2.getSomething(sql,ClassInfo.class).get(0);
    }

    @Override
    public ArrayList<ClassInfo> getAll()  {
        String sql = "SELECT * FROM class";
        return bd2.getSomething( sql,ClassInfo.class );
    }
}
