package com.woniu.dao;

import com.woniu.Bean.ShipmentInfo;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShipmentInfoDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( ShipmentInfo shipmentInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO SHIPMENT_INFO VALUES(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shipmentInfo.getShipmentID());
            ps.setInt(2,shipmentInfo.getCarID());
            ps.setInt(3,shipmentInfo.getDriverID());
            ps.setInt(4,shipmentInfo.getOrderID());
            ps.setString(5,shipmentInfo.getShipmentStatus());
            ps.setObject(6,shipmentInfo.getShipmentDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( ShipmentInfo shipmentInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE SHIPMENT_INFO SET carID=?,driverID=?,orderID=?,shipmentStatus=?,shipmentDate=? WHERE shipmentID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shipmentInfo.getCarID());
            ps.setInt(2,shipmentInfo.getDriverID());
            ps.setInt(3,shipmentInfo.getOrderID());
            ps.setString(4,shipmentInfo.getShipmentStatus());
            ps.setObject(5,shipmentInfo.getShipmentDate());
            ps.setInt(6,shipmentInfo.getShipmentID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer shipmentID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM SHIPMENT_INFO WHERE shipmentID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shipmentID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public ShipmentInfo findOne( Integer shipmentID ){
        ShipmentInfo shipmentInfo = new ShipmentInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM SHIPMENT_INFO WHERE shipmentID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,shipmentID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(shipmentInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return shipmentInfo;
    }
    public List<ShipmentInfo> findALl(){
        List<ShipmentInfo> shipmentInfos = new ArrayList<ShipmentInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM SHIPMENT_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ShipmentInfo shipmentInfo = new ShipmentInfo();
                setValue(shipmentInfo,rs);
                shipmentInfos.add(shipmentInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return shipmentInfos;
    }

    private void setValue(ShipmentInfo shipmentInfo,ResultSet rs) throws SQLException {
        shipmentInfo.setShipmentID(rs.getInt(1));
        shipmentInfo.setCarID(rs.getInt(2));
        shipmentInfo.setDriverID(rs.getInt(3));
        shipmentInfo.setOrderID(rs.getInt(4));
        shipmentInfo.setShipmentStatus(rs.getString(5));
        shipmentInfo.setShipmentDate(rs.getDate(6));
    }


}
