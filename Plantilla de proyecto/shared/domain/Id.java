package com.app.api.shared.domain;

import com.app.api.exceptions.IdException;

import lombok.Getter;

public class Id {
	
	@Getter
	private final String id;
	
	public Id(String value) {
		try {
			this.id = value;
			if (value.length() > 64 || value.length() < 32) {
				throw new IdException();
			}
			
		} catch (NullPointerException e) {
			throw new IdException();
		}
	}
	
}