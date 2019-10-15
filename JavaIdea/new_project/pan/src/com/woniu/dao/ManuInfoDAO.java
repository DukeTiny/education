package com.woniu.dao;

import com.woniu.Bean.ManuInfo;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManuInfoDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( ManuInfo manuInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO MANU_INFO VALUES(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,manuInfo.getManuId());
            ps.setString(2,manuInfo.getManuName());
            ps.setString(3,manuInfo.getManuAddress());
            ps.setString(4,manuInfo.getManuPhone());
            ps.setObject(5,manuInfo.getManuDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( ManuInfo manuInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE MANU_INFO SET manuName=?,manuAddress=?,manuPhone=?,manuDate=? WHERE manuID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,manuInfo.getManuName());
            ps.setString(2,manuInfo.getManuAddress());
            ps.setString(3,manuInfo.getManuPhone());
            ps.setObject(4,manuInfo.getManuDate());
            ps.setInt(5,manuInfo.getManuId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer manuID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM MANU_INFO WHERE manuID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,manuID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public ManuInfo findOne( Integer manuID ){
        ManuInfo manuInfo = new ManuInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM MANU_INFO WHERE manuID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,manuID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(manuInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return manuInfo;
    }
    public List<ManuInfo> findALl(){
        List<ManuInfo> manuInfos = new ArrayList<ManuInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM MANU_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                ManuInfo manuInfo = new ManuInfo();
                setValue(manuInfo,rs);
                manuInfos.add(manuInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return manuInfos;
    }

    private void setValue(ManuInfo manuInfo,ResultSet rs) throws SQLException {
        manuInfo.setManuId(rs.getInt(1));
        manuInfo.setManuName(rs.getString(2));
        manuInfo.setManuAddress(rs.getString(3));
        manuInfo.setManuPhone(rs.getString(4));
        manuInfo.setManuDate(rs.getDate(5));
    }
}
