package com.ferb.rest.demo01.utils;

public class StudentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6751402561655080423L;

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

}
