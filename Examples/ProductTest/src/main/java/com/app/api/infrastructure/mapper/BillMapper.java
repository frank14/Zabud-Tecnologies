package com.app.api.infrastructure.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.domain.model.Bill;
import com.app.api.domain.model.Item;
import com.app.api.infrastructure.dto.BillDto;
import com.app.api.infrastructure.rest.BillRest;
import com.app.api.shared.domain.Count;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.Price;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;
import com.example.demo.shared.dominio.Valor;

@Component
public class BillMapper implements MapperDto<BillDto, Bill>, MapperRest<BillRest, Bill> {
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public BillRest domRest(Bill o) {
		
		BillRest bill = new BillRest();

		bill.setCount(o.getCount().getCount());
		bill.setName(o.getName().getName());
		itemMapper.domRest((Item) o.getItems());
		bill.setTotalPrice(o.getTotalPrice().getTotalPrice());	

		return bill;
		
	}

	@Override
	public Bill restDom(BillRest i) {
		return Bill.of(new Count(i.getCount()), new Name(i.getName()), itemMapper.restDom(null), new Price(i.getTotalPrice()));
	}

	@Override
	public BillDto domDto(Bill o) {
		
		BillDto bill = new BillDto();

		bill.setCount(o.getCount().getCount());
		bill.setName(o.getName().getName());
		itemMapper.domRest((Item) o.getItems());
		bill.setTotalPrice(o.getTotalPrice().getTotalPrice());	

		return bill;
		
	}

	@Override
	public Bill dtoDom(BillDto i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
