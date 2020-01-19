package com.app.api.domain.service;

import java.util.List;

import com.app.api.domain.model.Product;
import com.app.api.shared.domain.Id;

public interface ProductService {
	
	public Product saveProduct(Product product);

	public Product getProduct(Id id);

	public List<Product> getProducts();

	public Product updateProduct(Product product, Id id);

	public void deleteProduct(Id id);
	
}
