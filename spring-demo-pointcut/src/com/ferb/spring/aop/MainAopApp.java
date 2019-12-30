package com.ferb.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ferb.spring.aop.dao.UserDao;

public class MainAopApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		UserDao theUserDao = context.getBean("userDao", UserDao.class);
		theUserDao.setFirstName("Ala");
		theUserDao.setLastName("Nowak");
		theUserDao.getFirstName();
		theUserDao.getLastName();
		theUserDao.addUser();
				
		context.close();

	}

}
