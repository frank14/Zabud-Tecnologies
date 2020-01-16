package com.api.infrastructure.repository.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.domain.model.Product;
import com.api.infrastructure.mapper.ProductMapper;
import com.api.infrastructure.repository.database.ProductRepository;
import com.api.shared.domain.Id;

@Service
public class ProductAdapter {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public Product saveProduct(Product product) {
		return productMapper.dtoDom(productRepository.save(productMapper.domDto(product)));
	}
	
	@Override
	public Product getProduct(Id id) {
		return productMapper.dtoDom(productRepositori);
	}
	
}

