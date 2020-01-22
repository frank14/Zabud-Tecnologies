package com.app.api.shared.domain;

import com.app.api.exceptions.PriceException;

public class Price {

	private final Double value;

	public Price(Double valor) {
		try {
			this.value = valor;
			if (valor <= 0) {
				throw new PriceException();
			}
		} catch (NullPointerException e) {
			throw new PriceException();
		}
	}

	public Double getValue() {
		return value;
	}

}
