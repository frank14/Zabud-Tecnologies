package com.app.api.shared.domain;

import com.app.api.exceptions.PhoneException;

import lombok.Getter;

public class Phone {
	
	@Getter
	private final Long phone;

	public Phone(Long value) {
		
		try {
			this.phone = value;
			
			if (value < 0) {
				throw new PhoneException();
			}

		} catch (NullPointerException e) {
			throw new PhoneException();
		}
		
	}
	
}
