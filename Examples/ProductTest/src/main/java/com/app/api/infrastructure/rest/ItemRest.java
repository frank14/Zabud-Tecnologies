package com.app.api.infrastructure.rest;

import lombok.Data;

@Data
public class ItemRest {
	
	private String id;
	private Integer count;
	private ProductRest product;
	private Double totalPrice;
	
	@Override
	public String toString() {
		return "\n\t\t\t{ id: " + id + ", cantidad: " + count + ", producto: " + product.toString() + ", valor total: " + totalPrice+" }";
	}
	
}
