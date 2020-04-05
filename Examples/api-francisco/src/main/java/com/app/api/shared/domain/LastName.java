package com.app.api.shared.domain;

import com.app.api.exceptions.LastNameException;

import lombok.Getter;

public class LastName {

	@Getter
	private final String lastName;

	public LastName(String value) {
		
		try {
			this.lastName = value;
			
			if (!value.matches("[A-Z|a-z].*")) {
				throw new LastNameException();
			}

		} catch (NullPointerException e) {
			throw new LastNameException();
		}
		
	}
	
}
