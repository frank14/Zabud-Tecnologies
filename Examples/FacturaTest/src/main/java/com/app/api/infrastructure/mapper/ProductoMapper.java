package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Product;
import com.app.api.infrastructure.dto.ProductDto;
import com.app.api.infrastructure.rest.ProductRest;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.Price;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class ProductoMapper implements MapperRest<ProductDto, Product>, MapperDto<ProductRest, Product> {

	@Override
	public ProductRest apitransformarDominioParaDto(Product o) {
		// TODO Auto-generated method stub
		ProductRest producto = new ProductRest();

		producto.setId(o.getId().getValue());
		producto.setNombre(o.getNombre().getValue());
		producto.setValor(o.getValor().getValue());

		return producto;
	}

	@Override
	public Product apitransformarDtoParaDominio(ProductRest i) {
		return Product.of(new Id(i.getId()), new Name(i.getNombre()), new Price(i.getValor()));
	}

	@Override
	public ProductDto transformarDominioParaDto(Product o) {

		ProductDto producto = new ProductDto();

		producto.setId(o.getId().getValue());
		producto.setNombre(o.getNombre().getValue());
		producto.setValor(o.getValor().getValue());

		return producto;
	}

	@Override
	public Product transformarDtoParaDominio(ProductDto i) {
		return Product.of(new Id(i.getId()), new Name(i.getNombre()), new Price(i.getValor()));
	}

}
