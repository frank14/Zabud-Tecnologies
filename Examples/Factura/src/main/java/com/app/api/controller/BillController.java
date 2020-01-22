package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.application.BillApplication;
import com.app.api.domain.service.BillService;
import com.app.api.domain.service.ProductService;
import com.app.api.infrastructure.mapper.BillMapper;
import com.app.api.infrastructure.mapper.ProductMapper;
import com.app.api.infrastructure.repository.database.BillRepository;
import com.app.api.infrastructure.rest.BillRest;

@RestController
@RequestMapping("/bills")
public class BillController {
	
	BillApplication billApplication;
	
	public BillController(@Autowired BillRepository billRepository, @Autowired BillService billService, @Autowired BillMapper billMapper, @Autowired ProductService productService, @Autowired ProductMapper productMapper) {
		this.billApplication = new BillApplication(billRepository, billService, billMapper, productService, productMapper);
	}
	
	@GetMapping
	public List<BillRest> getBills() {
		return billApplication.getBills();
	}
	
	@GetMapping("/{id}")
	public BillRest getBill(@PathVariable String id) {
		return billApplication.findBill(id);
	}
	
	@PostMapping
	public BillRest saveBill(@RequestBody BillRest bill) {
		return billApplication.save(bill);
	}
	
	@PutMapping("/{id}")
	public BillRest updateBill(@RequestBody BillRest bill, @PathVariable String id) {
		return billApplication.update(bill, id);
	}

	@DeleteMapping("/{id}")
	public void deleteBill(@PathVariable String id) {
		billApplication.delete(id);
	}
	
}
