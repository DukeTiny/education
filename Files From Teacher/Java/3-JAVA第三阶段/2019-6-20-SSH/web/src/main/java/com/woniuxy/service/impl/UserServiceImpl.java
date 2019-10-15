package com.woniuxy.service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.woniuxy.dao.IUserDao;
import com.woniuxy.dao.impl.UserDaoImpl;
import com.woniuxy.domain.User;
import com.woniuxy.service.IUserService;
import com.woniuxy.util.JdbcUtils;

public class UserServiceImpl implements IUserService {

	private IUserDao dao = new UserDaoImpl();
	
	@Override
	public void transfer(int from, int to, double money) {
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			User user = dao.find(from);
			User user2 = dao.find(to);
			
			System.out.println("service conn:" + conn);
			
			// 开启事务
			conn.setAutoCommit(false);
			
			user2.setMoney(user2.getMoney() + money);
			dao.update(user2);
			
			if(user.getMoney() < money) {
				throw new RuntimeException("余额不足：" + user.getMoney() + "，转账金额:" + money);
			}
			
			user.setMoney(user.getMoney() - money);
			dao.update(user);
			
			// 提交事务
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(null, null, conn);
		}
	}

}
