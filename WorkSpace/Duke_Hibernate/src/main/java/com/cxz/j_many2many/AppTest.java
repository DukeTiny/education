package com.cxz.j_many2many;


import org.hibernate.Session;
import org.junit.jupiter.api.Test;

public class AppTest {
	
	@Test
	void testSave() throws Exception {
		Session s = HibernateUtils.getSession();
		s.beginTransaction();
		//========================================================
		Teacher t = new Teacher();
		t.setName("洪七公");
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		s1.setName("郭靖");
		s2.setName("黄蓉");
		t.getStudents().add(s1);
		t.getStudents().add(s2);
		
//		s.save(s1);
//		s.save(s2);
		s.save(t);
		
		//========================================================
		s.getTransaction().commit();
		s.close();
	}
	
	@Test
	void testdelete() throws Exception {
		Session s = HibernateUtils.getSession();
		s.beginTransaction();
		//========================================================
		Teacher t = s.get(Teacher.class,1);
		s.delete(t);
		
		//========================================================
		s.getTransaction().commit();
		s.close();
	}


}
