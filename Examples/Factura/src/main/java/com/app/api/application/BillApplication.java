package com.app.api.application;

import com.app.api.domain.service.BillService;
import com.app.api.domain.service.ProductService;
import com.app.api.infrastructure.mapper.BillMapper;
import com.app.api.infrastructure.mapper.ProductMapper;
import com.app.api.infrastructure.repository.database.BillRepository;
import com.app.api.infrastructure.rest.BillRest;
import com.app.api.infrastructure.rest.ItemRest;
import com.app.api.infrastructure.rest.ProductRest;
import com.app.api.shared.domain.Id;

import java.util.List;
import java.util.UUID;

public class BillApplication {
	
	BillRepository billRepository;
	BillService billService;
	BillMapper billMapper;
	
	ProductService productService;
	ProductMapper productMapper;

	public BillApplication(BillRepository billRepository, BillService billService, BillMapper billMapper, ProductService productService, ProductMapper productMapper) {
		this.billRepository = billRepository;
		this.billService = billService;
		this.billMapper = billMapper;
		
		this.productService = productService;
		this.productMapper = productMapper;
	}
	
	public ProductRest getBill(String id) {
		return productMapper.domRest(productService.getProduct(id));
	}
	
	public List<BillRest> getBills() {
		return billMapper.listDomRest(billService.getBills());
	}
	
	public BillRest findBill(String id) {
		return billMapper.domRest(billService.getBill(new Id(id)));
	}
	
	public BillRest save(BillRest bill) {
		
		BillRest bi = bill;
		
		bi.setId(UUID.randomUUID().toString());
		bi.setItems(this.loadItems(bi.getItems()));
		bi.setTotalPrice(this.result(bi.getItems()));
		
		return billMapper.domRest(billService.save(billMapper.restDom(bi)));		
		
	}
	
	public List<ItemRest> loadItems(List<ItemRest> items) {

		for (ItemRest i : items) {
			i.setId(UUID.randomUUID().toString());
			i.setProduct(this.loadProduct(i.getProduct()));
			i.setTotalPrice(i.getCount() * i.getProduct().getPrice());
		}

		return items;
		
	}
	
	public ProductRest loadProduct(ProductRest product) {
		return productMapper.domRest(productService.getProduct(product.getId()));
	}
	
	public Double result(List<ItemRest> items) {
		double totalPrice = 0.0;
		
		for (ItemRest i : items) {
			totalPrice = totalPrice + (i.getCount() * i.getProduct().getPrice());
		}
		
		return totalPrice;
	}
	
	public BillRest update(BillRest bill, String id) {
		return billMapper.domRest(billService.updateBill(billMapper.restDom(bill), new Id(id)));
	}
	
	public void delete(String id) {
		billService.deleteBill(new Id(id));
	}
	
}
