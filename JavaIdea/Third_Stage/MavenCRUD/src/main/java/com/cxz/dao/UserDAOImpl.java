package com.cxz.dao;

import com.cxz.bean.User;
import com.cxz.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public void save(User user) {
        String sql = "INSERT INTO `user`(id,username,birthday,money) VALUES(null,?,?,?)";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setDate(2,new java.sql.Date(user.getBirthday().getTime()));
            ps.setDouble(3,user.getMoney());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(null,ps,con);
        }
    }

    public void update(User user) {
        String sql = "UPDATE `user` set username=?,birthday=?,money=? WHERE id=?";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setDate(2,new java.sql.Date(user.getBirthday().getTime()));
            ps.setDouble(3,user.getMoney());
            ps.setInt(4,user.getId());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(null,ps,con);
        }
    }

    public void delete(Integer id) {
        String sql = "DELETE FROM `user` WHERE id=?";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(null,ps,con);
        }
    }

    public List<User> find() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT *  FROM `user`";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            users = eval(rs);
            return users;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(rs,ps,con);
        }
    }

    public User find(Integer id) {
        User user;
        String sql = "SELECT * FROM `user` WHERE id=?";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs  = ps.executeQuery();
            rs.next();
            user = eval(rs).get(0);
            return user;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(rs,ps,con);
        }
    }

    @Override
    public int getRowCount() {
        String sql = "SELECT COUNT(*) FROM `user`";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            rs  = ps.executeQuery();
            int rowCount = 0;
            if( rs.next() ) rowCount = rs.getInt(1);
            return rowCount;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(rs,ps,con);
        }
    }

    @Override
    public List<User> find(int startLine, int size) {
        List<User> users;
        String sql = "SELECT *  FROM `user` LIMIT ?,?";
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,startLine);
            ps.setInt(2,size);
            rs  = ps.executeQuery();
            users = eval(rs);
            return users;
        } catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.free(rs,ps,con);
        }
    }

    private List<User> eval(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setBirthday(rs.getDate("birthday"));
            user.setMoney(rs.getDouble("money"));
            users.add(user);
        }
        return users;
    }
}
