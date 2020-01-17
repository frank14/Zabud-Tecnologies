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

import com.app.api.application.ProductApplication;
import com.app.api.domain.service.ProductService;
import com.app.api.infrastructure.mapper.ProductMapper;
import com.app.api.infrastructure.rest.ProductRest;

@RestController
@RequestMapping("/product")
public class ProductController {

	ProductApplication productApplication;

	public ProductController(@Autowired ProductMapper productMapper, @Autowired ProductService productService) {
		this.productApplication = new ProductApplication(productMapper, productService);
	}

	@GetMapping
	public List<ProductRest> getProduct() {
		return productApplication.getAll();
	}

	@GetMapping("/{id}")
	public ProductRest getProduct(@PathVariable String id) {
		return productApplication.findProduct(id);
	}

	@PostMapping("/saveProduct")
	public ProductRest saveProduct(@RequestBody ProductRest product) {
		return productApplication.save(product);
	}

	@PutMapping("/updateProduct/{id}")
	public ProductRest updateProduct(@RequestBody ProductRest product, @PathVariable String id) {
		return productApplication.update(product, id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	public void deleteProduct(@PathVariable String id) {
		productApplication.delete(id);
	}
	
}
