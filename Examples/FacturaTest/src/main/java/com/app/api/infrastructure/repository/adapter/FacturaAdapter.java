package com.app.api.infrastructure.repository.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Bill;
import com.app.api.domain.service.FacturaService;
import com.app.api.exceptions.RegisterNotFoundException;
import com.app.api.infrastructure.dto.BillDto;
import com.app.api.infrastructure.mapper.FacturaMapper;
import com.app.api.infrastructure.repository.database.FacturaRepository;
import com.app.api.shared.domain.Id;

@Service
public class FacturaAdapter implements FacturaService {

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	FacturaMapper facturaMapper;

	@Override
	public List<Bill> buscarPorIds(List<Id> codigos) {

		return facturaRepository
				.findAllById(codigos.stream().map(codigo -> codigo.getValue()).collect(Collectors.toList())).stream()
				.map(factura -> facturaMapper.apitransformarDtoParaDominio(factura)).collect(Collectors.toList());
	}

	@Override
	public List<Bill> buscarTodos() {
		return facturaMapper.apitransformarListaDtoParaDominio(facturaRepository.findAll());
	}

	@Override
	public void guardar(Bill bill) {
		facturaRepository.save(facturaMapper.apitransformarDominioParaDto(bill));
	}

	@Override
	public Bill buscarPorId(String id) {
		return facturaMapper.apitransformarDtoParaDominio(
				facturaRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException()));
	}

	@Override
	public void eliminarPorId(String id) {
		BillDto factura = facturaRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException());
		facturaRepository.deleteById(factura.getId());
	}

	@Override
	public void editar(Bill bill) {
		this.buscarPorId(bill.getId().getValue());
		facturaRepository.save(facturaMapper.apitransformarDominioParaDto(bill));

	}

}
