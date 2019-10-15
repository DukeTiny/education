package com.woniuxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.woniuxy.dao.IUserDao;
import com.woniuxy.domain.User;
import com.woniuxy.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {
	public User find(Integer id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where id = ?";
			conn = JdbcUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user = null;
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBirthday(rs.getDate("birthday"));
				user.setMoney(rs.getDouble("money"));
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(rs, ps, null);
		}
	}

	public void update(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtils.getConnection();
			System.out.println("dao conn:" + conn);
			String sql = "update user set name=?,birthday=?,money=? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBirthday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.setInt(4, user.getId());
			ps.executeUpdate();  // 小事务自动提交了
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, ps, null);
		}
	}

}
