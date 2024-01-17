package com.example.demo.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = -6616841492307853678L;

	public UserNotFoundException(String errorMessage, Throwable exception) {
		super(errorMessage, exception);
	}

	public UserNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
