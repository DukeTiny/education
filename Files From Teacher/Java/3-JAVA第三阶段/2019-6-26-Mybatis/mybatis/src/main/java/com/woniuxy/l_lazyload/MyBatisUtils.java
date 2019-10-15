package com.woniuxy.l_lazyload;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory sf;
	
	static {
		InputStream in = MyBatisUtils.class.getResourceAsStream("mybatis-config.xml");
		sf = new SqlSessionFactoryBuilder().build(in);
	}
	
	public static SqlSession openSession() {
		return sf.openSession(true);
	}
}
