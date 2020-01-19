package com.app.api.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.domain.model.Item;
import com.app.api.infrastructure.dto.ItemDto;
import com.app.api.infrastructure.rest.ItemRest;
import com.app.api.shared.domain.Count;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Price;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class ItemMapper implements MapperDto<ItemDto, Item>, MapperRest<ItemRest, Item> {
	
	@Autowired
	private ProductMapper productMapper;
	
	@Override
	public ItemRest domRest(Item o) {
		
		ItemRest item = new ItemRest();

		item.setId(o.getId().getId());
		item.setCount(o.getCount().getCount());
		productMapper.domRest(o.getProduct());
		item.setTotalPrice(o.getTotalPrice().getPrice());	

		return item;
		
	}

	@Override
	public Item restDom(ItemRest i) {
		return Item.of(new Id(i.getId()), new Count(i.getCount()), productMapper.restDom(i.getProduct()), new Price(i.getTotalPrice()));
	}

	@Override
	public ItemDto domDto(Item o) {
		
		ItemDto item = new ItemDto();

		item.setId(o.getId().getId());
		item.setCount(o.getCount().getCount());
		productMapper.domDto(o.getProduct());
		item.setTotalPrice(o.getTotalPrice().getPrice());	

		return item;
		
	}

	@Override
	public Item dtoDom(ItemDto i) {
		return Item.of(new Id(i.getId()), new Count(i.getCount()), productMapper.dtoDom(i.getProduct()), new Price(i.getTotalPrice()));
	}
	
}
