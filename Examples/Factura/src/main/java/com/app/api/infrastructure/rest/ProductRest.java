package com.app.api.infrastructure.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRest {
	
	private String id;
	private String code;
	private String name;
	private Double price;
	
}
