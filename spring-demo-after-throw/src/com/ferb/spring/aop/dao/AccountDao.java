package com.ferb.spring.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ferb.spring.aop.entity.Account;

@Component
public class AccountDao {

	public void addAccount(Account account) {
		System.out.println("Adding account to DB: " + account.toString());
	}
	
	public List<Account> findAccounts(boolean tripWire ) {
		
		if(tripWire) {
			throw new RuntimeException("Runtime Exception!!!");
		}
		
		List<Account> accounts = new ArrayList<>();
		Account acc01 = new Account("acc01", "level01");
		Account acc02 = new Account("acc02", "level02");
		Account acc03 = new Account("acc03", "level03");
		
		accounts.add(acc01);
		accounts.add(acc02);
		accounts.add(acc03);
		
		return  accounts;
	}
}
