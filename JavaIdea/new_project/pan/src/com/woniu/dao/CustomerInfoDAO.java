package com.woniu.dao;

import com.woniu.Bean.CustomerInfo;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerInfoDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( CustomerInfo customerInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO CUSTOMER_INFO VALUES(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customerInfo.getCustomerID());
            ps.setString(2,customerInfo.getCustomerName());
            ps.setString(3,customerInfo.getCustomerAddress());
            ps.setString(4,customerInfo.getCustomerPhone());
            ps.setObject(5,customerInfo.getCustomerDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( CustomerInfo customerInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE CUSTOMER_INFO SET customerName=?,customerAddress=?,customerPhone=?,customerDate=? WHERE customerID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,customerInfo.getCustomerName());
            ps.setString(2,customerInfo.getCustomerAddress());
            ps.setString(3,customerInfo.getCustomerPhone());
            ps.setObject(4,customerInfo.getCustomerDate());
            ps.setInt(5,customerInfo.getCustomerID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer customerID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM CUSTOMER_INFO WHERE customerID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customerID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public CustomerInfo findOne( Integer customerID ){
        CustomerInfo customerInfo = new CustomerInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM CUSTOMER_INFO WHERE customerID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,customerID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(customerInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return customerInfo;
    }
    public List<CustomerInfo> findALl(){
        List<CustomerInfo> customerInfos = new ArrayList<CustomerInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM CUSTOMER_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                CustomerInfo customerInfo = new CustomerInfo();
                setValue(customerInfo,rs);
                customerInfos.add(customerInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return customerInfos;
    }
    private void setValue(CustomerInfo customerInfo,ResultSet rs) throws SQLException {
        customerInfo.setCustomerID(rs.getInt(1));
        customerInfo.setCustomerName(rs.getString(2));
        customerInfo.setCustomerAddress(rs.getString(3));
        customerInfo.setCustomerPhone(rs.getString(4));
        customerInfo.setCustomerDate(rs.getDate(5));
    }

}
