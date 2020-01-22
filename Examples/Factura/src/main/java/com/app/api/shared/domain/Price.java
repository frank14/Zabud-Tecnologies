package com.app.api.shared.domain;

import com.app.api.exceptions.PriceException;

import lombok.Getter;

public class Price {

	@Getter
	private final Double price;

	public Price(Double value) {
		
		try {
			this.price = value;
						
			if (value <= 0) {
				throw new PriceException();
			}
			
		} catch (NullPointerException e) {
			throw new PriceException();
		}
		
	}
	
}
