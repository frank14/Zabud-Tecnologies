package com.app.api.infrastructure.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.domain.model.Bill;
import com.app.api.infrastructure.dto.BillDto;
import com.app.api.infrastructure.rest.BillRest;
import com.app.api.shared.domain.Client;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.TotalPrice;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class BillMapper implements MapperDto<BillDto, Bill>, MapperRest<BillRest, Bill> {
	
	@Autowired
	private ItemMapper itemMapper;
	
	@Override
	public BillRest domRest(Bill o) {
		
		BillRest bill = new BillRest();

		bill.setId(o.getId().getId());
		bill.setClient(o.getClient().getClient());
		
		bill.setItems(o.getItems().stream().map(item -> itemMapper.domRest(item))
				.collect(Collectors.toList()));
		
		bill.setTotalPrice(o.getTotalPrice().getTotalPrice());	

		return bill;
		
	}

	@Override
	public Bill restDom(BillRest i) {
		return Bill.of(
					new Id(i.getId()), 
					new Client(i.getClient()), 
					itemMapper.listRestDom(i.getItems()), 
					new TotalPrice(i.getTotalPrice())
				);
	}

	@Override
	public BillDto domDto(Bill o) {
		
		BillDto bill = new BillDto();

		bill.setId(o.getId().getId());
		bill.setClient(o.getClient().getClient());
		
		bill.setItems(o.getItems().stream().map(item -> itemMapper.domDto(item))
			.collect(Collectors.toList()));
		
		bill.setTotalPrice(o.getTotalPrice().getTotalPrice());	

		return bill;
		
	}

	@Override
	public Bill dtoDom(BillDto i) {
		return Bill.of(
					new Id(i.getId()), 
					new Client(i.getClient()), 
					itemMapper.listDtoDom(i.getItems()), 
					new TotalPrice(i.getTotalPrice())
				);	
		}
	
}
