package com.ferb.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyComplexAspect {
	
	@Pointcut("execution(* com.ferb.spring.aop.dao.*.get*())")
	public void forGetters() { }
	
	@Pointcut("execution(void com.ferb.spring.aop.dao.*.set*(..))")
	public void forSetters() { }
	
	@Pointcut("execution(void com.ferb.spring.aop.dao.*.*(..))")
	public void forAnyMethod() { }
	
	@Pointcut("forAnyMethod() && !forGetters() && !forSetters()")
	public void forAnyMethodExceptGetterOrSetter() { }
	
	@Before("forAnyMethodExceptGetterOrSetter()")
	public void adviceForAnyMethodExceptGetterOrSetter() {
		System.out.println("\n====> Executing @Before advice on any method except getter or setter");
	}
	
}