package com.cxz.quickstart;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CalcAspect {

	@Around("execution(public void com.cxz.quickstart.CalcImpl.add(int,int))")
	public Object f(ProceedingJoinPoint pjp) {
		try {
			Object r = null;
			System.out.println("AAAAAAAAAAA");
			pjp.proceed();
			System.out.println("BBBBBBBBBBB");
			return r;
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
