package com.woniu.dao;

import com.woniu.Bean.RouteInfo;
import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteInfoDao {
    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( RouteInfo routeInfo ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO ROUTE_INFO VALUES(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,routeInfo.getRouteID());
            ps.setString(2,routeInfo.getRoutesStart());
            ps.setString(3,routeInfo.getRouteEnd());
            ps.setInt(4,routeInfo.getRouteLength());
            ps.setObject(5,routeInfo.getRouteDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( RouteInfo routeInfo ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE ROUTE_INFO SET routeStart=?,routeEnd=?,routeLength=?,routeDate=? WHERE routeID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,routeInfo.getRoutesStart());
            ps.setString(2,routeInfo.getRouteEnd());
            ps.setInt(3,routeInfo.getRouteLength());
            ps.setObject(4,routeInfo.getRouteDate());
            ps.setInt(5,routeInfo.getRouteID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer routeID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM ROUTE_INFO WHERE routeID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,routeID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public RouteInfo findOne( Integer routeID ){
        RouteInfo routeInfo = new RouteInfo();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM ROUTE_INFO WHERE routeID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,routeID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(routeInfo,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return routeInfo;
    }
    public List<RouteInfo> findALl(){
        List<RouteInfo> routeInfos = new ArrayList<RouteInfo>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM ROUTE_INFO";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                RouteInfo routeInfo = new RouteInfo();
                setValue(routeInfo,rs);
                routeInfos.add(routeInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return routeInfos;
    }

    private void setValue(RouteInfo routeInfo,ResultSet rs) throws SQLException {
        routeInfo.setRouteID(rs.getInt(1));
        routeInfo.setRoutesStart(rs.getString(2));
        routeInfo.setRouteEnd(rs.getString(3));
        routeInfo.setRouteLength(rs.getInt(4));
        routeInfo.setRouteDate(rs.getDate(5));
    }
}
