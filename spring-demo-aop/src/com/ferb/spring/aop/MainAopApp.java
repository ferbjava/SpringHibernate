package com.ferb.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ferb.spring.aop.dao.AccountDao;

public class MainAopApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		
		theAccountDao.addAccount();
		
		System.out.println("\nLets try it again!\n");
		theAccountDao.addAccount();
		
		context.close();

	}

}
