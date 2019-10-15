package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDAO2<T> {

    Connection con;
    PreparedStatement state;
    ResultSet rs;
    public void doSomething(String sql, ArrayList al) {
        try {
            con = ClassDaoUtil.getCon();
            state = con.prepareStatement(sql);
            for ( int i=0; i<al.size(); i++ ) {
                if ( al.get(i) instanceof Integer ) state.setInt(i+1,Integer.parseInt(String.valueOf(al.get(i))));
                if ( al.get(i) instanceof String ) state.setString(i+1, (String) al.get(i));
            }
            state.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,rs,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<T> getSomething(String sql,Class c) {
        ArrayList<T> outAl = new ArrayList<>();
        try {
            con = ClassDaoUtil.getCon();
            state = con.prepareStatement(sql);
            rs = state.executeQuery();
            while ( rs.next() ){
                T t = (T) c.newInstance();
                Method[] ms = c.getDeclaredMethods();
                for ( Method m:ms ){
                    String mName = m.getName();
                    if( mName.startsWith("set") ){
                        m.getParameters();
                        m.invoke(t,rs.getObject(mName.substring(3)));
                    }
                }
                outAl.add(t);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,rs,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return outAl;
    }

}
