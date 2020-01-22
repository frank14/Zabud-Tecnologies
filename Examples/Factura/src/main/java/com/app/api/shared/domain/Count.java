package com.app.api.shared.domain;

import com.app.api.exceptions.CountException;

import lombok.Getter;

public class Count {
	
	@Getter
	private final Integer count;

	public Count(Integer value) {
		
		try {
			this.count = value;
						
			if (value <= 0) {
				throw new CountException();
			}

		} catch (NullPointerException e) {
			throw new CountException();
		}
		
	}
	
}
