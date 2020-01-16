package com.api.shared.domain;

import com.api.exceptions.NameException;

import lombok.Getter;

public class Name {
	
	@Getter
	private final String name;
	
	public Name(String value) {
		
		try {
			this.name = value;
			
			if (!value.matches("[a-z].*")) {
				throw new NameException();
			}
			
		} catch (NullPointerException e) {
			throw new NameException();
		}
		
	}
	
}
