package com.woniuxy.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class TransactionAspect {
	
	@Autowired
	private SessionFactory sf;
	
	@Around("execution(* com.woniuxy.service.impl.DeptServiceImpl.*(..))")
	public Object f1(ProceedingJoinPoint pjp) {
		Object r = null;
		Session s = sf.getCurrentSession();
		s.beginTransaction();
		try {
			r = pjp.proceed();
			s.getTransaction().commit();
			return r;
		} catch (Throwable e) {
			s.getTransaction().rollback();
			throw new RuntimeException(e);
		} finally {
			s.close();
		}
	}
	
}
