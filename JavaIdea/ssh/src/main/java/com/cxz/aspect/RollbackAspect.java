package com.cxz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RollbackAspect {

    @Autowired
    private SessionFactory sf;

    private Session getSession() {
        return sf.getCurrentSession();
    }

    @Around("execution(* com.cxz.service.impl.DeptServiceImpl.*(..))")
    public Object rollback(ProceedingJoinPoint pjp) {
        Object r = null;
        try {
            System.out.println("开始");
            r = pjp.proceed();
            System.out.println("结束");
            return r;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
        }
    }

}
