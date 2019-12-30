package com.ferb.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

	public void addAccount() {
		System.out.println(getClass() + " adding Membership account to DB");
	}
	
	public void addShittyNameMethod() {
		System.out.println(getClass() + " some random method");
	}
	
	public boolean addBooleanMethod() {
		System.err.println(getClass() + " some boolean method");
		return false;
	}
}
