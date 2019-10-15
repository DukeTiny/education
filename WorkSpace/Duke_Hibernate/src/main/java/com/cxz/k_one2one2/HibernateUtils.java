package com.cxz.k_one2one2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sf = null;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("com/cxz/k_one2one2/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory(); 
	}
	
	public static Session getSession() {
		return sf.openSession();
	}
	
	
}
