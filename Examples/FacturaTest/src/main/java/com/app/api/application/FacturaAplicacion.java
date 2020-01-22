package com.app.api.application;

import java.util.List;
import java.util.UUID;

import com.app.api.domain.service.FacturaService;
import com.app.api.domain.service.ProductoService;
import com.app.api.infrastructure.mapper.FacturaMapper;
import com.app.api.infrastructure.mapper.ProductoMapper;
import com.app.api.infrastructure.repository.database.FacturaRepository;
import com.app.api.infrastructure.rest.BillRest;
import com.app.api.infrastructure.rest.ItemRest;
import com.app.api.infrastructure.rest.ProductRest;

public class FacturaAplicacion {

	FacturaRepository facturaRepository;
	FacturaService facturaService;
	FacturaMapper facturaMapper;
	ProductoService productoService;
	ProductoMapper productoMapper;

	public FacturaAplicacion(FacturaRepository facturaRepository, FacturaService facturaService,
			FacturaMapper facturaMapper, ProductoService productoService, ProductoMapper productoMapper) {
		this.facturaRepository = facturaRepository;
		this.facturaService = facturaService;
		this.facturaMapper = facturaMapper;
		this.productoService = productoService;
		this.productoMapper = productoMapper;
	}

	//
	public List<BillRest> getFacturas() {
		return facturaMapper.transformarListDominioParaDto(facturaService.buscarTodos());
	}

	public BillRest getFactura(String id) {
		return facturaMapper.transformarDominioParaDto(facturaService.buscarPorId(id));
	}

	// ***********************************************************************************************

	public void addFactura(BillRest factura) {
		BillRest fa = factura;
		fa.setId(UUID.randomUUID().toString());
		fa.setItem(this.cargarItems(fa.getItem()));
		fa.setTotal(this.calcularFactura(fa.getItem()));

		facturaService.guardar(facturaMapper.transformarDtoParaDominio(fa));
	}

	public List<ItemRest> cargarItems(List<ItemRest> items) {
		for (ItemRest i : items) {
			i.setId(UUID.randomUUID().toString());
			i.setProducto(this.cargarProducto(i.getProducto()));
			i.setTotal(i.getCantidad() * i.getProducto().getValor());
		}

		return items;
	}

	public ProductRest cargarProducto(ProductRest producto) {
		return productoMapper.apitransformarDominioParaDto(productoService.buscarPorId(producto.getId()));
	}

	public Double calcularFactura(List<ItemRest> item) {
		double total = 0.0;
		for (ItemRest i : item) {
			total = total + (i.getCantidad() * i.getProducto().getValor());
		}
		return total;
	}

	// ***********************************************************************************************

	public void editFactura(BillRest factura) {
		facturaService.buscarPorId(factura.getId());
		facturaService.editar(facturaMapper.transformarDtoParaDominio(factura));
	}

	public void deleteFactura(String id) {
		facturaService.eliminarPorId(id);
	}

	// Solo para pruebas, no es utilizado en producción
	public void deleteAll() {
		facturaRepository.deleteAll();
	}
}
