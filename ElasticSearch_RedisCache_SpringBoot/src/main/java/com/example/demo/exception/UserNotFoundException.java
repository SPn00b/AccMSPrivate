package com.example.demo.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String errorMessage, Throwable exception) {
		// TODO Auto-generated constructor stub
		super(errorMessage, exception);
	}

	public UserNotFoundException(String errorMessage) {
		// TODO Auto-generated constructor stub
		super(errorMessage);
	}

}
