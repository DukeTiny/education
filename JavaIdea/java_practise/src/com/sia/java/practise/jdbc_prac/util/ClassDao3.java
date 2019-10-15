package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.jdbc_prac.Dao.IClassDao;
import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.sql.*;
import java.util.ArrayList;

public class ClassDao3 implements IClassDao {

    @Override
    public void add( ClassInfo ci ) {
        String sql = "INSERT INTO class VALUES(?,?,?)";
        ArrayList al = new ArrayList();
        al.add(ci.getCid()); al.add(ci.getCname()); al.add(ci.getCnum());
        BaseDAO.doSomething(sql,al);
    }

    @Override
    public void del( int c ) {
        String sql = "DELETE FROM class WHERE cid=?";
        ArrayList al = new ArrayList();
        al.add(c);
        BaseDAO.doSomething(sql,al);
    }

    @Override
    public void change( ClassInfo ci  ) {
        String sql = "UPDATE class SET cname=?,cnum=? WHERE cid=?";
        ArrayList al = new ArrayList();
        al.add(ci.getCname());  al.add(ci.getCnum());  al.add(ci.getCid());
        BaseDAO.doSomething(sql,al);
    }

    @Override
    public ClassInfo getSingle(int cid) {
        String sql = "SELECT * FROM class WHERE cid="+cid;
        return BaseDAO.getSomething(sql).get(0);
    }

    @Override
    public ArrayList<ClassInfo> getAll() {
        String sql = "SELECT * FROM class";
        return BaseDAO.getSomething(sql);
    }
}
