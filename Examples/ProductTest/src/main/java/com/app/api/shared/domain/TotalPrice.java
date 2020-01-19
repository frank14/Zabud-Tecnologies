package com.app.api.shared.domain;

import com.app.api.exceptions.PriceException;

import lombok.Getter;

public class TotalPrice {
	
	@Getter
	private final Double totalPrice;

	public TotalPrice(Double value) {
		
		try {
			this.totalPrice = value;
			
			if (value <= 0) {
				throw new PriceException();
			}
			
		} catch (NullPointerException e) {
			throw new PriceException();
		}
		
		
	}
	
}
