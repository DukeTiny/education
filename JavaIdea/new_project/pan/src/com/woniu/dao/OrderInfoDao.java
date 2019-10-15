package com.woniu.dao;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.woniu.Bean.OrderInfo;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderInfoDao {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( OrderInfo orderInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO ORDER_INFO VALUES(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderInfo.getOrderID());
            ps.setInt(2,orderInfo.getGMID());
            ps.setInt(3,orderInfo.getCustomerID());
            ps.setInt(4,orderInfo.getRouteID());
            ps.setFloat(5,orderInfo.getShipmentCost());
            ps.setString(6,orderInfo.getOrderStatus());
            ps.setObject(7,orderInfo.getOrderDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( OrderInfo orderInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE ORDER_INFO SET GMID=?,customerID=?,routeID=?,shipmentCost=?,orderStatus=?,oderDate=? WHERE orderID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderInfo.getGMID());
            ps.setInt(2,orderInfo.getCustomerID());
            ps.setInt(3,orderInfo.getRouteID());
            ps.setFloat(4,orderInfo.getShipmentCost());
            ps.setString(5,orderInfo.getOrderStatus());
            ps.setObject(6,orderInfo.getOrderDate());
            ps.setInt(7,orderInfo.getOrderID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer orderID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM ORDER_INFO WHERE orderID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public OrderInfo findOne( Integer orderID ){
        OrderInfo orderInfo = new OrderInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM ORDER_INFO WHERE orderID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,orderID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(orderInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return orderInfo;
    }
    public List<OrderInfo> findALl(){
        List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM ORDER_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                OrderInfo orderInfo = new OrderInfo();
                setValue(orderInfo,rs);
                orderInfos.add(orderInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return orderInfos;
    }
    private void setValue(OrderInfo orderInfo,ResultSet rs) throws SQLException {
        orderInfo.setOrderID(rs.getInt(1));
        orderInfo.setGMID(rs.getInt(2));
        orderInfo.setCustomerID(rs.getInt(3));
        orderInfo.setRouteID(rs.getInt(4));
        orderInfo.setShipmentCost(rs.getFloat(5));
        orderInfo.setOrderStatus(rs.getString(6));
        orderInfo.setOrderDate(rs.getDate(7));
    }


}
