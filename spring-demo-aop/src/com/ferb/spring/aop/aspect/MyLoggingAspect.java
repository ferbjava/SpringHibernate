package com.ferb.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====> Executing @Before advice on addAccount()");
	}

	@Before("execution(public void com.ferb.spring.aop.dao.AccountDao.addAccount())")
	public void beforeAddAccountAdviceOnClass() {
		System.out.println("\n====> Executing @Before advice on AccountDao.addAccount()");
	}

	@Before("execution(public void add*())")
	public void beforeAddWhateverMethodAdvice() {
		System.out.println("\n====> Executing @Before advice on addWhatever() method");
	}

	@Before("execution(void add*())")
	public void beforeAnyMethodTypeAdvice() {
		System.out.println("\n====> Executing @Before advice on anyType method");
	}
	
}