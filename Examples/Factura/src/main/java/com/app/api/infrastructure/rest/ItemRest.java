package com.app.api.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRest {
	
	private String id;
	private Integer count;
	private ProductRest product;
	private Double totalPrice;
	
}
