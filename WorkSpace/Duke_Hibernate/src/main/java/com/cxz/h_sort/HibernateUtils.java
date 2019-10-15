package com.cxz.h_sort;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static SessionFactory sf;
	static{
		Configuration cfg = new Configuration();
		cfg.configure("com/cxz/h_sort/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		Session s = sf.openSession();
		s.beginTransaction();
		return s;
	}
	
	public static void free(Session s) {
		s.getTransaction().commit();
		s.close();
	}
	
	
	public static void main(String[] args) {
		Session s = getSession();
		s.beginTransaction();
		User user = new User();
		user.setName("Tiny");
		s.save(user);
		free(s);
	}

}
