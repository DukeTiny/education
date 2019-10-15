package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.jdbc_prac.Dao.IClassDao;
import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ClassDao implements IClassDao {
    String iDriver ="com.mysql.jdbc.Driver";
    String url = "JDBC:mysql://localhost:3306/exercise7";
    String username = "root";
    String pass = "wh809919";
    Connection con;
    Statement state;
    ResultSet rs;
    ClassInfo ci;

    @Override
    public void add( ClassInfo ci ) {
        try {
            Class.forName(iDriver);
            con = DriverManager.getConnection(url,username,pass);
            state = con.createStatement();
            this.ci = ci;
            state.executeUpdate("INSERT INTO class VALUES('"+ci.getCid()+"','"+ci.getCname()+"','"+ci.getCnum()+"')");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void del( int cid ) {
        try {
            Class.forName(iDriver);
            con = DriverManager.getConnection(url,username,pass);
            state = con.createStatement();
            state.executeUpdate("DELETE FROM class WHERE cid="+cid);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void change( ClassInfo ci  ) {
        try {
            Class.forName(iDriver);
            con = DriverManager.getConnection(url,username,pass);
            state = con.createStatement();
            this.ci = ci;
            state.executeUpdate("UPDATE class SET cname='"+ci.getCname()+"',cnum="+ci.getCnum()+" WHERE cid="+ci.getCid());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClassInfo getSingle(int cid) {
        ClassInfo cInfo=null;
        try {
            Class.forName(iDriver);
            con = DriverManager.getConnection(url,username,pass);
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM class WHERE cid="+cid);
            if ( rs.next() ){
                cInfo = new ClassInfo();
                cInfo.setCid( rs.getInt(1) );
                cInfo.setCname( rs.getString( 2 ));
                cInfo.setCnum( rs.getInt(3) );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return cInfo;

    }

    @Override
    public ArrayList<ClassInfo> getAll() {
        ArrayList<ClassInfo> al = new ArrayList<>();
        try {
            Class.forName(iDriver);
            con = DriverManager.getConnection(url,username,pass);
            state = con.createStatement();
            rs = state.executeQuery("SELECT * FROM class");
            while ( rs.next() ){
                ClassInfo cInfo= new ClassInfo();
                cInfo.setCid( Integer.parseInt( rs.getString(1) ) );
                cInfo.setCname( rs.getString( 2 ));
                cInfo.setCnum( Integer.parseInt( rs.getString(3) ) );
                System.out.println(cInfo.getCid()+","+cInfo.getCname()+","+cInfo.getCnum());
                al.add(cInfo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return al;
    }
}
