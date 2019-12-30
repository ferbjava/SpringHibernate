package com.ferb.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAspect {
	
	@Before("com.ferb.spring.aop.aspect.MyExpressions.forPackage()")
	public void performApiAnylytics() {
		System.out.println("\n====> Perform API analytics");
	}
	
}