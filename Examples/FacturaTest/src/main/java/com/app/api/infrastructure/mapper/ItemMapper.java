package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Item;
import com.app.api.domain.model.Product;
import com.app.api.infrastructure.dto.ItemDto;
import com.app.api.infrastructure.dto.ProductDto;
import com.app.api.infrastructure.rest.ItemRest;
import com.app.api.infrastructure.rest.ProductRest;
import com.app.api.shared.domain.Count;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.TotalPrice;
import com.app.api.shared.domain.Price;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class ItemMapper implements MapperRest<ItemDto, Item>, MapperDto<ItemRest, Item> {

	@Override
	public ItemRest apitransformarDominioParaDto(Item o) {

		ItemRest item = new ItemRest();

		item.setId(o.getId().getValue());
		item.setCantidad(o.getCantidad().getValue());

		item.setProducto(new ProductRest(o.getProducto().getId().getValue(), o.getProducto().getNombre().getValue(),
				o.getProducto().getValor().getValue()));

		item.setTotal(o.getTotal().getTotal());

		return item;
	}

	@Override
	public Item apitransformarDtoParaDominio(ItemRest i) {
		return Item.of(new Id(i.getId()), new Count(i.getCantidad()), new TotalPrice(i.getTotal()),
				Product.of(new Id(i.getProducto().getId()), new Name(i.getProducto().getNombre()),
						new Price(i.getProducto().getValor())));
	}

	@Override
	public ItemDto transformarDominioParaDto(Item o) {

		ItemDto item = new ItemDto();

		ProductDto producto = new ProductDto();

		producto.setId(o.getProducto().getId().getValue());
		producto.setNombre(o.getProducto().getNombre().getValue());
		producto.setValor(o.getProducto().getValor().getValue());

		item.setId(o.getId().getValue());
		item.setCantidad(o.getCantidad().getValue());
		item.setProducto(producto);
		item.setTotal(o.getTotal().getTotal());

		return item;
	}

	@Override
	public Item transformarDtoParaDominio(ItemDto i) {
		return Item.of(new Id(i.getId()), new Count(i.getCantidad()), new TotalPrice(i.getTotal()),
				Product.of(new Id(i.getProducto().getId()), new Name(i.getProducto().getNombre()),
						new Price(i.getProducto().getValor())));

	}

}
