package com.app.api.application;

import java.util.List;
import java.util.UUID;

import com.app.api.domain.service.ProductService;
import com.app.api.infrastructure.mapper.ProductMapper;
import com.app.api.infrastructure.rest.ProductRest;
import com.app.api.shared.domain.Id;

public class ProductApplication {
	
	ProductService productService;
	
	ProductMapper productMapper;
	
	public ProductApplication(ProductMapper productMapper, ProductService productService) {
		this.productMapper = productMapper;
		this.productService = productService;
	}

	public ProductRest save(ProductRest product) {
		product.setId(UUID.randomUUID().toString());
		return productMapper.domRest(productService.saveProduct(productMapper.restDom(product)));
	}

	public void delete(String id) {
		productService.deleteProduct(new Id(id));
	}

	public ProductRest update(ProductRest product, String id) {
		return productMapper.domRest(productService.updateProduct(productMapper.restDom(product), new Id(id)));
	}

	public List<ProductRest> getAll() {
		return productMapper.listDomRest(productService.getProducts());
	}

	public ProductRest findProduct(String id) {
		return productMapper.domRest(productService.getProduct(id));
	}
	
}
