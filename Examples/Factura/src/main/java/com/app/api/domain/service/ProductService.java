package com.app.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Product;
import com.app.api.shared.domain.Id;

@Component
public interface ProductService {
	
	public Product saveProduct(Product product);

	public Product getProduct(String string);

	public List<Product> getProducts();

	public Product updateProduct(Product product, Id id);

	public void deleteProduct(Id id);
	
}
