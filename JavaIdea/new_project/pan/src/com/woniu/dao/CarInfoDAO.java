package com.woniu.dao;

import com.woniu.Bean.CarInfo;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarInfoDAO {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( CarInfo carInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO CAR_INFO VALUES(?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,carInfo.getCarID());
            ps.setString(2,carInfo.getCarBrand());
            ps.setString(3,carInfo.getCarEnginenID());
            ps.setString(4,carInfo.getCarStatus());
            ps.setInt(5,carInfo.getCarAge());
            ps.setObject(6,carInfo.getCarDate());
            ps.setInt(7,carInfo.getCarFlag());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( CarInfo carInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE CAR_INFO SET carBrand=?,carEnginenID=?,carStatus=?,carAge=?,carDate=?,carFlag=? WHERE carID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,carInfo.getCarBrand());
            ps.setString(2,carInfo.getCarEnginenID());
            ps.setString(3,carInfo.getCarStatus());
            ps.setInt(4,carInfo.getCarAge());
            ps.setObject(5,carInfo.getCarDate());
            ps.setInt(6,carInfo.getCarFlag());
            ps.setInt(7,carInfo.getCarID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer carID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM CAR_INFO WHERE carID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,carID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public CarInfo findOne( Integer carID ){
        CarInfo carInfo = new CarInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM CAR_INFO WHERE carID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,carID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(carInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return carInfo;
    }
    public List<CarInfo> findALl(){
        List<CarInfo> carInfos = new ArrayList<CarInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM CAR_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                CarInfo carInfo = new CarInfo();
                setValue(carInfo,rs);
                carInfos.add(carInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return carInfos;
    }

    private void setValue(CarInfo carInfo,ResultSet rs) throws SQLException {
        carInfo.setCarID(rs.getInt(1));
        carInfo.setCarBrand(rs.getString(2));
        carInfo.setCarEnginenID(rs.getString(3));
        carInfo.setCarStatus(rs.getString(4));
        carInfo.setCarAge(rs.getInt(5));
        carInfo.setCarDate(rs.getDate(6));
        carInfo.setCarFlag(rs.getInt(7));
    }

}
