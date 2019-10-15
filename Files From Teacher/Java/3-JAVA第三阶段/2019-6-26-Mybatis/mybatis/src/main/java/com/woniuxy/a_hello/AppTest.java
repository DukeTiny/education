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
		// ����һ��������������������������ȡmybatis�����õģ�
		// ��Ϊ�������ļ����Ѿ����ù����������ļ������Ը�������Ҳ�ܰ��������ļ������ݶ�ȡ��
		
		// AppTest.class.getClassLoader().getResourceAsStream(String ..)�Ǵ���·����ʼ����Դ
		// AppTest.class.getResourceAsStream(String ..)�Ǵ�AppTest.class����Ŀ¼��ʼ����Դ
		InputStream in = AppTest.class.getResourceAsStream("mybatis-config.xml");
		
		// ����SqlSessionFactory������SqlSessionFactory�����ͻ�������ļ��е���Ϣ�����ص��Լ����ڴ��У�
		// Ҳ����˵���������е���Ϣ�����������е���Ϣ��SqlSessionFactory�����С�֪�����ˣ�
		SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
		// ����SqlSessionFactory����SqlSession��SqlSession��ʾһ���Ự
		// �ûỰ���Ӵ����ݿ����ӿ�ʼ�����ر����ݿ�����Ϊֹ��
		// һ����ȡ��һ��SqlSession������ô����ͻ��Զ�������
		SqlSession s = sf.openSession();
		// ======================================================
		
		User user = new User();
		user.setName("aaa");
		user.setBirthday(new Date());
		user.setMoney(888d);
		
		// �ҵ�һ��sql��䣬��ִ�и�sql���
		// mybatisĿǰ��������sql���ģ�����com.woniuxy.a_hello.UserMapper�����ҵ��������ļ�
		// �ٸ���.save�ҵ�ĳһ�������sql��䣡�ҵ�sql���֮�󣬻��ò��������԰�sql�С��ӡ����ϣ�Ȼ���ٷ��͸�mysql������
		s.insert("com.woniuxy.a_hello.UserMapper.save", user);
		
		// ======================================================
		// �ύ����
		s.commit();
		// �رջỰ���ײ���ʵ�ǹر����ݿ����ӣ�������ʵ�ǣ������ݿ����ӹ黹�����ӳ��С�
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
		user.setName("÷����");
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
