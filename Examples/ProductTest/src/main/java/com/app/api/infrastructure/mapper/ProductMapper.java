package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Product;
import com.app.api.infrastructure.dto.ProductDto;
import com.app.api.infrastructure.rest.ProductRest;
import com.app.api.shared.domain.Code;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.Price;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class ProductMapper implements MapperDto<ProductDto, Product>, MapperRest<ProductRest, Product> {

	@Override
	public ProductRest domRest(Product o) {
		
		ProductRest product = new ProductRest();

		product.setId(o.getId().getId());
		product.setCode(o.getCode().getCode());
		product.setName(o.getName().getName());
		product.setPrice(o.getPrice().getPrice());	

		return product;
		
	}

	@Override
	public Product restDom(ProductRest i) {
		return Product.of(new Id(i.getId()), new Code(i.getCode()), new Name(i.getName()), new Price(i.getPrice()));
	}

	@Override
	public ProductDto domDto(Product o) {
		
		ProductDto product = new ProductDto();

		product.setId(o.getId().getId());
		product.setCode(o.getCode().getCode());
		product.setName(o.getName().getName());
		product.setPrice(o.getPrice().getPrice());	

		return product;
		
	}

	@Override
	public Product dtoDom(ProductDto i) {
		return Product.of(new Id(i.getId()), new Code(i.getCode()), new Name(i.getName()), new Price(i.getPrice()));
	}

}
