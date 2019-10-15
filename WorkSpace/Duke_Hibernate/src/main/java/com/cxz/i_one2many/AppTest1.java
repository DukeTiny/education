package com.cxz.i_one2many;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Test;

public class AppTest1 {
	
	
	// Dept.hbm.xml维护Emp
	
	@Test
	void testSave() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/cxz/i_one2many/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		// ====================================================================
		// 部门记住员工
		Dept d = new Dept();
		d.setDname("Design");
		
		Emp e = new Emp();
		e.setEname("Duke");
		Emp e2 = new Emp();
		e2.setEname("Tiny");
		
		d.getEmps().add(e);
		d.getEmps().add(e2);
		s.save(e);
		s.save(e2);
		s.save(d);
		
		// ====================================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	void testUpdate() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/cxz/i_one2many/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		// ====================================================================
		// 部门记住员工
		Dept d = s.get(Dept.class,3);
		
		Emp e = s.get(Emp.class,3);
		
		d.getEmps().remove(e);
		s.save(e);
		s.update(d);
		
		// ====================================================================
		s.getTransaction().commit();
		s.close();
		
	}
	
	@Test
	void testDelete() throws Exception {
		Configuration cfg = new Configuration();
		cfg.configure("com/cxz/i_one2many/hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		// ====================================================================
		// 部门记住员工
		
		Emp e = s.get(Emp.class,5);
		System.out.println(e.getDept());
		
		// ====================================================================
		s.getTransaction().commit();
		s.close();
		
	}

}
