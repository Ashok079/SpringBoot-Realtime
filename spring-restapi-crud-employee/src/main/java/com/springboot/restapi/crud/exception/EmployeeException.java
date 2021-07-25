package com.springboot.restapi.crud.exception;

public class EmployeeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeException(String message) {
		super(message);
	}

	public EmployeeException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
