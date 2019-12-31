package com.ferb.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ferb.spring.aop.entity.Account;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {

	@AfterReturning(
			pointcut = "com.ferb.spring.aop.aspect.MyExpressions.afterReturning()",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("\\n====> Execution @AfterReturning on method: " + method);

		System.out.println("\\n====> Results is: " + result);
		
		convertAccountNamesToUpperCase(result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		result.forEach(a -> a.setName(a.getName().toUpperCase()));
		
	}

}