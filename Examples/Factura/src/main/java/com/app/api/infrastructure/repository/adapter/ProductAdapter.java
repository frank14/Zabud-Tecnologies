package com.app.api.infrastructure.repository.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Product;
import com.app.api.domain.service.ProductService;
import com.app.api.infrastructure.mapper.ProductMapper;
import com.app.api.infrastructure.repository.database.ProductRepository;
import com.app.api.shared.domain.Id;

@Service
public class ProductAdapter implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public Product saveProduct(Product product) {
		return productMapper.dtoDom(productRepository.save(productMapper.domDto(product)));
	}

	@Override
	public Product getProduct(String id) {
		return productMapper.dtoDom(productRepository.findById(id).orElseThrow(() -> new RuntimeException()));
	}

	@Override
	public List<Product> getProducts() {
		return productMapper.listDtoDom(productRepository.findAll());
	}

	@Override
	public Product updateProduct(Product product, Id id) {
		Product findProduct = product;
		saveProduct(product);
		return findProduct;
	}

	@Override
	public void deleteProduct(Id id) {
		productRepository.deleteById(id.getId());	
	}
	
}
