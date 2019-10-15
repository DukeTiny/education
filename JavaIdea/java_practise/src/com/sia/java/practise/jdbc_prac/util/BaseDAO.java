package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;

public class BaseDAO {

    static Connection con;
    static PreparedStatement state;
    static ResultSet rs;
    public static void doSomething(String sql, ArrayList al) {
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

    public static ArrayList<ClassInfo> getSomething(String sql) {
        ArrayList<ClassInfo> outAl = new ArrayList<>();
        try {
            con = ClassDaoUtil.getCon();
            state = con.prepareStatement(sql);
            rs = state.executeQuery();
            while ( rs.next() ){
                ClassInfo ci = new ClassInfo();
                ci.setCid(rs.getInt("cid"));
                ci.setCnum(rs.getInt("cnum"));
                ci.setCname(rs.getString("cname"));
                outAl.add(ci);
            }
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
        return outAl;
    }

}
