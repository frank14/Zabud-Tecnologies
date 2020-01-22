package com.app.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Bill;
import com.app.api.shared.domain.Id;

@Component
public interface FacturaService {

	public List<Bill> buscarPorIds(List<Id> codigos);

	public List<Bill> buscarTodos();

	public void guardar(Bill bill);

	public Bill buscarPorId(String id);

	public void eliminarPorId(String id);

	public void editar(Bill bill);

}
