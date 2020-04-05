package com.app.api.shared.domain;

import com.app.api.exceptions.EmailException;

import lombok.Getter;

public class Email {

	@Getter
	private final String email;

	public Email(String value) {
		
		try {
			this.email = value;
			
			if (!value.matches("^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) {
				throw new EmailException();
			}

		} catch (NullPointerException e) {
			throw new EmailException();
		}
		
	}
	
}
