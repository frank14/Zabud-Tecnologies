package com.app.api.exceptions;

public class RegisterNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegisterNotFoundException() {
		super("Register not found");
	}
}
