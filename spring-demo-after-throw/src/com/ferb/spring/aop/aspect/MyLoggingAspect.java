package com.ferb.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {
	
	@AfterThrowing(pointcut="com.ferb.spring.aop.aspect.MyExpressions.afterReturning()",
					throwing="theExc")
	public void afterThrowingAccoutAdvice(JoinPoint joinPoint, Throwable theExc) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\\n====> Execution @AfterThrowing on method: " + method);
		System.out.println("\\n====> The Exception is: " + theExc);

	}

}