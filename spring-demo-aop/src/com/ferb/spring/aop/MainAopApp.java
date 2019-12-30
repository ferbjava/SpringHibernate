package com.ferb.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ferb.spring.aop.dao.AccountDao;
import com.ferb.spring.aop.dao.MembershipDao;
import com.ferb.spring.aop.entity.Account;

public class MainAopApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		MembershipDao theMembershipDao = context.getBean("membershipDao", MembershipDao.class);
		
		Account account = new Account("someAccount", "level00");
		theAccountDao.addAccount(account);
		
		System.out.println("\nLets try it on different class!\n");
		theMembershipDao.addAccount();
		
		theMembershipDao.addShittyNameMethod();
		
		theMembershipDao.addBooleanMethod();
		
		context.close();

	}

}
