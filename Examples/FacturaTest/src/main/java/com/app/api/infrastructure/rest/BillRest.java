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
	private String cliente;
	private List<ItemRest> item;
	private Double totalPrice;

}
