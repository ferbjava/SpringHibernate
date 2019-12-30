package com.ferb.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

	public void addAccount() {
		System.out.println(getClass() + " adding account to DB");
	}
}
