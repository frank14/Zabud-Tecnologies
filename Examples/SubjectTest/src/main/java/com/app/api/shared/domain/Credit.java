package com.app.api.shared.domain;

import com.app.api.exceptions.CreditException;

import lombok.Getter;

public class Credit {

	@Getter
	private final Integer credit;

	public Credit(Integer value) {
		
		try {
			this.credit = value;
			
			if (value < 0 || value > 4) {
				throw new CreditException();
			}
			
		} catch (NullPointerException e) {
			throw new CreditException();
		}
		
		
	}
	
}
