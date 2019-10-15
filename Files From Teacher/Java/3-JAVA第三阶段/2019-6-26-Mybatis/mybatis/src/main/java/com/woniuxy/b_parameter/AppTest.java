package com.woniuxy.b_parameter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class AppTest {
	@Test
	public void test() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		Foo f = new Foo();
		f.setName("������");
		f.setBirthday(new Date());
		f.setMoney(999d);
		f.setAddress("�����");
		s.insert("com.woniuxy.b_parameter.UserMapper.save", f);
		// ======================================================
		s.close();
	}
	
	@Test
	public void test2() throws Exception {
		SqlSession s = MyBatisUtils.openSession();
		// ======================================================
		Map map = new HashMap();
		map.put("name","��ѧ��");
		map.put("birthday",new Date());
		map.put("money",1000d);
		s.insert("com.woniuxy.b_parameter.UserMapper.save", map);
		
		// ======================================================
		s.close();
	}
	
}
