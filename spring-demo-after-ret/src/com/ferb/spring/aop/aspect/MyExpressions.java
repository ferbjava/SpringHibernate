package com.ferb.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyExpressions {
	
	@Pointcut("execution(* com.ferb.spring.aop.dao.AccountDao.findAccounts(..))")
	public void afterReturning() { }

}
