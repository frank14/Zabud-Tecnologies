package com.app.api.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Product;

@Component
public interface ProductoService {
	
	public List<Product> buscarPorIds(List<String> codigos);

	public List<Product> buscarTodos();

	public void guardar(Product product);

	public Product buscarPorId(String id);

	public void eliminarPorId(String id);

	public void editar(Product product);
	
}
