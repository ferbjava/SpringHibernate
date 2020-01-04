package com.ferb.spring.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ferb.spring.aop.dao.AccountDao;
import com.ferb.spring.aop.entity.Account;

public class AfterFinalMainApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDao theAccountDao = context.getBean("accountDao", AccountDao.class);
		List<Account> accounts = null;
		
		try {
			System.out.println("Exception case:");
			boolean tripWire = true;
			accounts = theAccountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main program catch Exception: " + e);
		}

		
		try {
			System.out.println("Regular case:");
			boolean tripWire = false;
			accounts = theAccountDao.findAccounts(tripWire);
		} catch (Exception e) {
			System.out.println("Main program catch Exception: " + e);
		}
		System.out.println("----");
		System.out.println("Accounts: " + accounts + "\n");
		
		context.close();

	}

}
