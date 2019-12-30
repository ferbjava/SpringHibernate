package com.ferb.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ferb.spring.aop.dao.AccountDao;
import com.ferb.spring.aop.dao.MembershipDao;

public class MainAopApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		MembershipDao theMembershipDao = context.getBean("membershipDao", MembershipDao.class);
		
		theAccountDao.addAccount();
		
		System.out.println("\nLets try it on different class!\n");
		theMembershipDao.addShittyNameMethod();
		
		theMembershipDao.addBooleanMethod();
		
		context.close();

	}

}
