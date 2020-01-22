package com.app.api.infrastructure.rest;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillRest {
	
	private String id;
	private String client;
	private List<ItemRest> items;
	private Double totalPrice;
	
}
