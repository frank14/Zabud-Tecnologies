package com.app.api.shared.domain;

import com.app.api.exceptions.TotalPriceException;

import lombok.Getter;

public class TotalPrice {

	@Getter
	private final Double totalPrice;

	public TotalPrice(Double value) {
		
		try {
			this.totalPrice = value;
			
			if (value <= 0) {
				throw new TotalPriceException();
			}
			
		} catch (NullPointerException e) {
			throw new TotalPriceException();
		}
			
	}

}
