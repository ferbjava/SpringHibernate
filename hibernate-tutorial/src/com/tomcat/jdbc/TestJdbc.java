package com.tomcat.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
		String user = "hbstudent";
		String pwd = "hbstudent";
		
		try {
			
			System.out.println("COnnecting to database: " + jdbcUrl);
			Connection connection = DriverManager.getConnection(jdbcUrl, user, pwd);
			System.out.println("Is it working?");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
