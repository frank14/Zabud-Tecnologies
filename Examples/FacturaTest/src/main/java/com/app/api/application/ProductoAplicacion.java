package com.app.api.application;

import java.util.List;
import java.util.UUID;

import com.app.api.domain.service.ProductoService;
import com.app.api.infrastructure.mapper.ProductoMapper;
import com.app.api.infrastructure.rest.ProductRest;

public class ProductoAplicacion {

	ProductoService productoService;

	ProductoMapper productoMapper;

	public ProductoAplicacion(ProductoService productoService, ProductoMapper productoMapper) {
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	public void crear(ProductRest p) {
		if (p.getId() == null) {
			p.setId(UUID.randomUUID().toString());
		}
		productoService.guardar(productoMapper.apitransformarDtoParaDominio(p));
	}

	public List<ProductRest> listar() {
		return productoMapper.apitransformarListDominioParaDto(productoService.buscarTodos());
	}

	public ProductRest buscar(String codigo) {
		return productoMapper.apitransformarDominioParaDto(productoService.buscarPorId(codigo));
	}

	public void eliminar(String codigo) {
		productoService.eliminarPorId(codigo);
	}

	public void actualizar(ProductRest p) {
		productoService.editar(productoMapper.apitransformarDtoParaDominio(p));
	}

}
