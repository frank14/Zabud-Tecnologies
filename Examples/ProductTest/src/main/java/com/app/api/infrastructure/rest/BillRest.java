package com.app.api.infrastructure.rest;

import java.util.List;

import lombok.Data;

@Data
public class BillRest {
	
	private Integer count;
	private String name;
	private List<ItemRest> items;
	private Double totalPrice;
	
	@Override
	public String toString() {
		return "{ \tnFactura N°:" + count + ", \n\t\tCliente: " + name + ", \n\t\titems: " + items.toString() + ", \n\t\tTotal a pagar: " + totalPrice + "\n}";
	}
	
}
