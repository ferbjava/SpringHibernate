package com.ferb.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class MyMethodWithParamsAspect {
	
	@Pointcut("execution(* com.ferb.spring.aop.dao.*.set*(..))")
	public void forSetters() { }
	
	@Before("forSetters()()")
	public void adviceMethodWithParams(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("\n====> Executing @Before for method: " + methodSignature);
		
		for(Object arg: joinPoint.getArgs()) {
			System.out.println("Argument: " + arg.getClass());
		}
	}
	
}