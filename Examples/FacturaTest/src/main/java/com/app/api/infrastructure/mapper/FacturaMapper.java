package com.app.api.infrastructure.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.api.domain.model.Bill;
import com.app.api.infrastructure.dto.BillDto;
import com.app.api.infrastructure.rest.BillRest;
import com.app.api.shared.domain.Client;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Telefono;
import com.app.api.shared.domain.TotalPrice;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class FacturaMapper implements MapperDto<BillDto, Bill>, MapperRest<BillRest, Bill> {

	@Autowired
	ItemMapper itemMaper;

	@Override
	public BillDto apitransformarDominioParaDto(Bill o) {

		BillDto factura = new BillDto();

		factura.setId(o.getId().getValue());
		factura.setCliente(o.getCliente().getNombre());
		factura.setItem(o.getItem().stream().map(item -> itemMaper.transformarDominioParaDto(item))
				.collect(Collectors.toList()));
		factura.setTelefono(o.getTelefono().getTelefono());
		factura.setTotal(o.getTotal().getTotal());

		return factura;
	}

	@Override
	public Bill apitransformarDtoParaDominio(BillDto i) {

		return Bill.of(new Id(i.getId()), new TotalPrice(i.getTotal()), new Client(i.getCliente()),
				new Telefono(i.getTelefono()), i.getItem().stream()
						.map(item -> itemMaper.transformarDtoParaDominio(item)).collect(Collectors.toList()));

	}

	@Override
	public BillRest transformarDominioParaDto(Bill o) {

		BillRest factura = new BillRest();

		factura.setId(o.getId().getValue());
		factura.setCliente(o.getCliente().getNombre());
		factura.setItem(itemMaper.apitransformarListDominioParaDto(o.getItem()));
		factura.setTelefono(o.getTelefono().getTelefono());
		factura.setTotal(o.getTotal().getTotal());

		return factura;
	}

	@Override
	public Bill transformarDtoParaDominio(BillRest i) {
		return Bill.of(new Id(i.getId()), new TotalPrice(i.getTotal()), new Client(i.getCliente()),
				new Telefono(i.getTelefono()), itemMaper.apitransformarListaDtoParaDominio(i.getItem()));
	}

}
