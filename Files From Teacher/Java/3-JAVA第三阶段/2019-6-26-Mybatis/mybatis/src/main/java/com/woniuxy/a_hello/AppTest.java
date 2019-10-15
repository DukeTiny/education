package com.woniuxy.a_hello;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		// 创建一个输入流，该输入流是用来读取mybatis主配置的！
		// 因为主配置文件夹已经配置过了子配置文件，所以该输入流也能把子配置文件的内容读取到
		
		// AppTest.class.getClassLoader().getResourceAsStream(String ..)是从类路径开始找资源
		// AppTest.class.getResourceAsStream(String ..)是从AppTest.class所在目录开始找资源
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		
		// 创建SqlSessionFactory工厂，SqlSessionFactory工厂就会把配置文件中的信息都加载到自己的内存中！
		// 也就是说，主配置中的信息，和子配置中的信息，SqlSessionFactory对象有“知道”了！
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// 根据SqlSessionFactory生成SqlSession，SqlSession表示一个会话
		// 该会话，从打开数据库连接开始，到关闭数据库连接为止。
		// 一旦获取了一个SqlSession对象，那么事务就会自动开启。
		SqlSession s = sf.openSession();
		// ======================================================
		
		User user = new User();
		user.setName("aaa");
		user.setBirthday(new Date());
		user.setMoney(888d);
		
		// 找到一个sql语句，并执行该sql语句
		// mybatis目前是这样找sql语句的：拿着com.woniuxy.a_hello.UserMapper，能找到子配置文件
		// 再根据.save找到某一个具体的sql语句！找到sql语句之后，会用参数的属性把sql中“坑”填上，然后再发送给mysql服务器
		s.insert("com.woniuxy.a_hello.UserMapper.save", user);
		
		// ======================================================
		// 提交事务
		s.commit();
		// 关闭会话，底层其实是关闭数据库连接，这里其实是，把数据库连接归还给连接池中。
		s.close();
	}
	
	@Test
	public void test2() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================
		
		s.delete("com.woniuxy.a_hello.UserMapper.delete", 8);
		
		// ======================================================
		s.commit();
		s.close();
	}
	
	@Test
	public void test3() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================
		User user = new User();
		user.setId(6);
		user.setName("梅超风");
		user.setBirthday(new Date());
		user.setMoney(678d);
		s.update("com.woniuxy.a_hello.UserMapper.update", user);
		
		// ======================================================
		s.commit();
		s.close();
	}
	
	@Test
	public void test4() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================
		
		List<User> list = s.selectList("com.woniuxy.a_hello.UserMapper.findAll"); 
		for (User user : list) {
			System.out.println(user);
		}
		
		
		// ======================================================
		s.commit();
		s.close();
	}
	
	@Test
	public void test5() throws Exception {
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		SqlSession s = sf.openSession();
		// ======================================================
		
//		List<User> list = s.selectList("com.woniuxy.a_hello.UserMapper.findOne", 1); 
//		System.out.println(list);
		
		User user = s.selectOne("com.woniuxy.a_hello.UserMapper.findOne", 1); 
		System.out.println(user);
		
		// ======================================================
		s.commit();
		s.close();
	}
}
