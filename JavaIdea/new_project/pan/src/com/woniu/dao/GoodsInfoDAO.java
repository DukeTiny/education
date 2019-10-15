package com.woniu.dao;

import com.woniu.Bean.GoodsInfo;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsInfoDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( GoodsInfo goodsInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO GOODS_INFO VALUES(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,goodsInfo.getGoodsID());
            ps.setString(2,goodsInfo.getGoodsName());
            ps.setString(3,goodsInfo.getGoodsUnit());
            ps.setFloat(4,goodsInfo.getGoodsUnitPrice());
            ps.setInt(5,goodsInfo.getGoodsWeight());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( GoodsInfo goodsInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE GOODS_INFO SET goodsName=?,goodsUnit=?,goodsUnitPrice=?,goodsWeight=? WHERE goodsID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,goodsInfo.getGoodsName());
            ps.setString(2,goodsInfo.getGoodsUnit());
            ps.setFloat(3,goodsInfo.getGoodsUnitPrice());
            ps.setInt(4,goodsInfo.getGoodsWeight());
            ps.setInt(5,goodsInfo.getGoodsID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer goodsID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM GOODS_INFO WHERE goodsID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,goodsID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public GoodsInfo findOne( Integer goodsID ){
        GoodsInfo goodsInfo = new GoodsInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM GOODS_INFO WHERE goodsID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,goodsID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(goodsInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return goodsInfo;
    }
    public List<GoodsInfo> findALl(){
        List<GoodsInfo> goodsInfos = new ArrayList<GoodsInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM GOODS_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                GoodsInfo goodsInfo = new GoodsInfo();
                setValue(goodsInfo,rs);
                goodsInfos.add(goodsInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return goodsInfos;
    }

    private void setValue(GoodsInfo goodsInfo,ResultSet rs) throws SQLException {
        goodsInfo.setGoodsID(rs.getInt(1));
        goodsInfo.setGoodsName(rs.getString(2));
        goodsInfo.setGoodsUnit(rs.getString(3));
        goodsInfo.setGoodsUnitPrice(rs.getFloat(4));
        goodsInfo.setGoodsWeight(rs.getInt(5));
    }

}
