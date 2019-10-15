package com.woniu.dao;

import com.woniu.Bean.SysUser;
import com.woniu.util.DAOUtil;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SysUserDAO {

    private static PreparedStatement ps;
    private static Connection conn;
    private static ResultSet rs;

    public void save( SysUser sysUser ){
        conn = DAOUtil.getCon();
        String sql = "INSERT INTO SYS_USER VALUES(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sysUser.getUserID());
            ps.setString(2,sysUser.getUserLoginName());
            ps.setString(3,sysUser.getUserRealName());
            ps.setString(4,sysUser.getUserPassword());
            ps.setString(5,sysUser.getUserPhone());
            ps.setObject(6,sysUser.getUserDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }

    }
    public void update( SysUser sysUser ){
        conn = DAOUtil.getCon();
        String sql = "UPDATE SYS_USER SET userLoginName=?,userRealName=?,userPassword=?,userPhone=?,userDate=? WHERE userID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1,sysUser.getUserLoginName());
            ps.setString(2,sysUser.getUserRealName());
            ps.setString(3,sysUser.getUserPassword());
            ps.setString(4,sysUser.getUserPhone());
            ps.setObject(5,sysUser.getUserDate());
            ps.setInt(6,sysUser.getUserID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public void delete( Integer userID ){
        conn = DAOUtil.getCon();
        String sql = "DELETE FROM SYS_USER WHERE userID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
    }
    public SysUser findOne( Integer userID ){
        SysUser sysUser = new SysUser();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM SYS_USER WHERE userID=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,userID);
            ResultSet rs = ps.executeQuery();
            rs.next();
            setValue(sysUser,rs);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return sysUser;
    }
    public List<SysUser> findALl(){
        List<SysUser> sysUsers = new ArrayList<SysUser>();
        conn = DAOUtil.getCon();
        String sql = "SELECT * FROM SYS_USER";
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                SysUser sysUser = new SysUser();
                setValue(sysUser,rs);
                sysUsers.add(sysUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DAOUtil.closeAll(rs,ps,conn);
        }
        return sysUsers;
    }
    private void setValue(SysUser sysUser,ResultSet rs) throws SQLException {
        sysUser.setUserID(rs.getInt(1));
        sysUser.setUserLoginName(rs.getString(2));
        sysUser.setUserRealName(rs.getString(3));
        sysUser.setUserPassword(rs.getString(4));
        sysUser.setUserPhone(rs.getString(5));
        sysUser.setUserDate(rs.getDate(6));
    }
}
