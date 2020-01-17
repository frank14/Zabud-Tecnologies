package com.app.api.shared.domain;

import com.app.api.exceptions.NameException;

import lombok.Getter;

public class Name {

	@Getter
	private final String name;

	public Name(String value) {
		
		try {
			this.name = value;
			
			if (!value.matches("[A-Z].*")) {
				throw new NameException();
			}

		} catch (NullPointerException e) {
			throw new NameException();
		}
		
	}

}
