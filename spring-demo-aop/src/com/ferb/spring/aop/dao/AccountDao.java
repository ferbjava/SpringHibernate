package com.ferb.spring.aop.dao;

import org.springframework.stereotype.Component;

import com.ferb.spring.aop.entity.Account;

@Component
public class AccountDao {

	public void addAccount(Account account) {
		System.out.println("Adding account to DB: " + account.toString());
	}
}
