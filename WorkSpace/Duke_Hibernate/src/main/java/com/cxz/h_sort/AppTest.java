package com.cxz.h_sort;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class AppTest {
	
	private IUserDao dao = new UserDaoImpl();
	
	@Test
	void testSave() throws Exception {
		User user = new User();
		user.setName("Duke");
		user.setBirthday(new Date());
		user.setMoney(100D);
		user.getAddresses().add("洛杉矶-L");
		user.getAddresses().add("纽约-N");
		user.getAddresses().add("西雅图-S");
		user.getAddresses().add("休斯敦-H");
		user.getAddresses().add("德克萨斯-D");
		dao.save(user);
		
	}
	
	@Test
	void testGet() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/cxz/h_sort/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		User user = s.get(User.class,1);
		System.out.println(user.getAddresses());
		s.getTransaction().commit();
		s.close();
	}
}
