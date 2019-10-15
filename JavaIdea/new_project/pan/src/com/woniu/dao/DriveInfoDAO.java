package com.woniu.dao;

import com.woniu.Bean.DriverInfo;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriveInfoDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( DriverInfo driverInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO DRIVER_INFO VALUES(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,driverInfo.getDriverID());
            ps.setString(2,driverInfo.getDriverName());
            ps.setInt(3,driverInfo.getDriverYear());
            ps.setString(4,driverInfo.getDriverPhoto());
            ps.setInt(5,driverInfo.getDriverFlag());
            ps.setObject(6,driverInfo.getDriverDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( DriverInfo driverInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE DRIVER_INFO SET driverName=?,driveYear=?,driverPhoto=?,driverFlag=?,driverDate=? WHERE driverID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,driverInfo.getDriverName());
            ps.setInt(2,driverInfo.getDriverYear());
            ps.setString(3,driverInfo.getDriverPhoto());
            ps.setInt(4,driverInfo.getDriverFlag());
            ps.setObject(5,driverInfo.getDriverDate());
            ps.setInt(6,driverInfo.getDriverID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer driverID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM DRIVER_INFO WHERE driverID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,driverID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public DriverInfo findOne( Integer driverID ){
        DriverInfo driverInfo = new DriverInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM DRIVER_INFO WHERE driverID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,driverID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(driverInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return driverInfo;
    }
    public List<DriverInfo> findALl(){
        List<DriverInfo> driverInfos = new ArrayList<DriverInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM DRIVER_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                DriverInfo driverInfo = new DriverInfo();
                setValue(driverInfo,rs);
                driverInfos.add(driverInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return driverInfos;
    }

    private void setValue(DriverInfo driverInfo,ResultSet rs) throws SQLException {
        driverInfo.setDriverID(rs.getInt(1));
        driverInfo.setDriverName(rs.getString(2));
        driverInfo.setDriverYear(rs.getInt(3));
        driverInfo.setDriverPhoto(rs.getString(4));
        driverInfo.setDriverFlag(rs.getInt(5));
        driverInfo.setDriverDate(rs.getDate(5));
    }
}
