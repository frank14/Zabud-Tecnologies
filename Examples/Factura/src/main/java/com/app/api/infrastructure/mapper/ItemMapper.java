package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Item;
import com.app.api.domain.model.Product;
import com.app.api.infrastructure.dto.ItemDto;
import com.app.api.infrastructure.dto.ProductDto;
import com.app.api.infrastructure.rest.ItemRest;
import com.app.api.infrastructure.rest.ProductRest;
import com.app.api.shared.domain.Code;
import com.app.api.shared.domain.Count;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.Price;
import com.app.api.shared.domain.TotalPrice;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class ItemMapper implements MapperDto<ItemDto, Item>, MapperRest<ItemRest, Item> {
	
	@Override
	public ItemRest domRest(Item o) {
		
		ItemRest item = new ItemRest();

		item.setId(o.getId().getId());
		item.setCount(o.getCount().getCount());
		
		item.setProduct(new ProductRest( 
					o.getProduct().getId().getId(), 
					o.getProduct().getCode().getCode(),
					o.getProduct().getName().getName(),
					o.getProduct().getPrice().getPrice()
				));
		
		item.setTotalPrice(o.getTotalPrice().getTotalPrice());	

		return item;
		
	}

	@Override
	public Item restDom(ItemRest i) {
		return Item.of(
					new Id(i.getId()), 
					new Count(i.getCount()), 
					Product.of(
								new Id(i.getProduct().getId()), 
								new Code(i.getProduct().getCode()), 
								new Name(i.getProduct().getName()), 
								new Price(i.getProduct().getPrice())
							),
					new TotalPrice(i.getTotalPrice())
				);
	}

	@Override
	public ItemDto domDto(Item o) {
		
		ItemDto item = new ItemDto();

		item.setId(o.getId().getId());
		item.setCount(o.getCount().getCount());
		
		item.setProduct(new ProductDto(
					o.getProduct().getId().getId(),
					o.getProduct().getCode().getCode(),
					o.getProduct().getPrice().getPrice()
				));
		
		item.setTotalPrice(o.getTotalPrice().getTotalPrice());	

		return item;
		
	}

	@Override
	public Item dtoDom(ItemDto i) {
 
		return Item.of(
				new Id(i.getId()), 
				new Count(i.getCount()), 
				Product.of(
							new Id(i.getProduct().getId()), 
							new Code(i.getProduct().getCode()), 
							new Name(i.getProduct().getName()), 
							new Price(i.getProduct().getPrice())
						),
				new TotalPrice(i.getTotalPrice())
			);
		
	}
	
}
