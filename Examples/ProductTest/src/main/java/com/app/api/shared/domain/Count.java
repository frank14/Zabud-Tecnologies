package com.app.api.shared.domain;

import com.app.api.exceptions.CodeException;

import lombok.Getter;

public class Count {
	
	@Getter
	private final Integer count;

	public Count(Integer value) {
		
		try {
			this.count = value;
			
			if (value < 0) {
				throw new CodeException();
			}

		} catch (NullPointerException e) {
			throw new CodeException();
		}
		
	}
	
}
