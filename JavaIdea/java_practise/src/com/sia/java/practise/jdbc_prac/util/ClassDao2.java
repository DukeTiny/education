package com.sia.java.practise.jdbc_prac.util;

import com.sia.java.practise.jdbc_prac.Dao.IClassDao;
import com.sia.java.practise.jdbc_prac.bean.ClassInfo;

import java.sql.*;
import java.util.ArrayList;

public class ClassDao2 implements IClassDao {

    Connection con;
    PreparedStatement state;
    ResultSet rs;
    ClassInfo ci;

    @Override
    public void add( ClassInfo ci ) {
        try {
            con = ClassDaoUtil.getCon();
            this.ci = ci;
            String sql = "INSERT INTO class VALUES(?,?,?)";
            state = con.prepareStatement(sql);
            state.setInt(1,ci.getCid());
            state.setString(2,ci.getCname());
            state.setInt(3,ci.getCnum());
            state.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,null,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void del( int c ) {
        try {
            con = ClassDaoUtil.getCon();
            String sql = "DELETE FROM class WHERE cid=?";
            state = con.prepareStatement(sql);
            state.setInt(1,c);
            state.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,null,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void change( ClassInfo ci  ) {
        try {
            con = ClassDaoUtil.getCon();
            this.ci = ci;
            String sql = "UPDATE class SET cname=?,cnum=? WHERE cid=?";
            state = con.prepareStatement(sql);
            state.setString(1,ci.getCname());
            state.setInt(2,ci.getCnum());
            state.setInt(3,ci.getCid());
            state.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,null,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ClassInfo getSingle(int cid) {
        ClassInfo cInfo=null;
        try {
            con = ClassDaoUtil.getCon();
            String sql = "SELECT * FROM class WHERE cid=?";
            state = con.prepareStatement(sql);
            state.setInt(1,cid);
            rs = state.executeQuery();
            if ( rs.next() ){
                cInfo = new ClassInfo();
                cInfo.setCid( Integer.parseInt( rs.getString(1) ) );
                cInfo.setCname( rs.getString( 2 ));
                cInfo.setCnum( Integer.parseInt( rs.getString(3) ) );
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,rs,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cInfo;
    }

    @Override
    public ArrayList<ClassInfo> getAll() {
        ArrayList<ClassInfo> al = new ArrayList<>();
        try {
            con = ClassDaoUtil.getCon();
            String sql = "SELECT * FROM class";
            state = con.prepareStatement(sql);
            rs = state.executeQuery();
            while ( rs.next() ){
                ClassInfo cInfo= new ClassInfo();
                cInfo.setCid( Integer.parseInt( rs.getString(1) ) );
                cInfo.setCname( rs.getString( 2 ));
                cInfo.setCnum( Integer.parseInt( rs.getString(3) ) );
                al.add(cInfo);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ClassDaoUtil.closeAll(state,rs,con);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return al;
    }
}
