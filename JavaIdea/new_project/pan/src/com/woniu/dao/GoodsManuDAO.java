package com.woniu.dao;

import com.woniu.Bean.GoodsInfo;
import com.woniu.Bean.GoodsManu;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsManuDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( GoodsManu goodsManu ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO GOODS_MANU VALUES(?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,goodsManu.getGMID());
            ps.setInt(2,goodsManu.getManuID());
            ps.setInt(3,goodsManu.getGoodsID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( GoodsManu goodsManu ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE GOODS_MANU SET manuID=?,goodsID=? WHERE GMID=? ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,goodsManu.getManuID());
            ps.setInt(2,goodsManu.getGoodsID());
            ps.setInt(3,goodsManu.getGMID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer GMID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM GOODS_MANU WHERE GMID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,GMID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public GoodsManu findOne( Integer GMID ){
        GoodsManu goodsManu = new GoodsManu();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM GOODS_MANU WHERE GMID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,GMID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(goodsManu,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return goodsManu;
    }
    public List<GoodsManu> findALl(){
        List<GoodsManu> goodsManus = new ArrayList<GoodsManu>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM GOODS_MANU";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                GoodsManu goodsManu = new GoodsManu();
                setValue(goodsManu,rs);
                goodsManus.add(goodsManu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return goodsManus;
    }

    private void setValue(GoodsManu goodsManu,ResultSet rs) throws SQLException {
        goodsManu.setGMID(rs.getInt(1));
        goodsManu.setManuID(rs.getInt(2));
        goodsManu.setGoodsID(rs.getInt(3));
    }
}
