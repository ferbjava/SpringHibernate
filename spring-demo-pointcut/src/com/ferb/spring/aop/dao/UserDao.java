package com.ferb.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

	private String firstName;
	
	private String lastName;
	
	public UserDao() {
	}

	public UserDao(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		System.out.println("in getFirstName");
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("in setFirstName");
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("in getLastName");
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("in setLastName");
		this.lastName = lastName;
	}
	
	public void addUser() {
		System.out.println("in addUser() method");
	}
	
}
