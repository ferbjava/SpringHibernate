package com.ferb.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {

	@Before("com.ferb.spring.aop.aspect.MyExpressions.forPackage()")
	public void beforeAddAccountAdviceWithParam() {
		System.out.println("\n====> Executing @Before advice on add for package");
	}
	
}