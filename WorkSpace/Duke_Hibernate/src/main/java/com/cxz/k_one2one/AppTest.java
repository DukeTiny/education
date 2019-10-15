package com.cxz.k_one2one;


import org.hibernate.Session;
import org.junit.jupiter.api.Test;

public class AppTest {
	
	@Test
	void testSave() throws Exception {
		Session s = HibernateUtils.getSession();
		s.beginTransaction();
		//========================================================
		Wife w = new Wife();
		w.setWname("Li Fei");
		Husband h = new Husband();
		h.setHname("王虎");
		w.setHusband(h);
		s.save(w);
		
		//========================================================
		s.getTransaction().commit();
		s.close();
	}
	
	@Test
	void testdelete() throws Exception {
		Session s = HibernateUtils.getSession();
		s.beginTransaction();
		//========================================================
		
		//========================================================
		s.getTransaction().commit();
		s.close();
	}


}
