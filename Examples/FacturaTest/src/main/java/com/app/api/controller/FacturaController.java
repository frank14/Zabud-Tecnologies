package com.app.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.application.FacturaAplicacion;
import com.app.api.domain.service.FacturaService;
import com.app.api.domain.service.ProductoService;
import com.app.api.infrastructure.mapper.FacturaMapper;
import com.app.api.infrastructure.mapper.ProductoMapper;
import com.app.api.infrastructure.repository.database.FacturaRepository;
import com.app.api.infrastructure.rest.BillRest;

@RestController
@RequestMapping("/factura")
public class FacturaController {

	FacturaAplicacion facturaAplicacion;

	public FacturaController(@Autowired FacturaRepository facturaRepository, @Autowired FacturaService facturaService,
			@Autowired FacturaMapper facturaMapper, @Autowired ProductoService productoService,
			@Autowired ProductoMapper productoMapper) {
		this.facturaAplicacion = new FacturaAplicacion(facturaRepository, facturaService, facturaMapper,
				productoService, productoMapper);
	}

	@GetMapping
	public List<BillRest> getFacturas() {
		return facturaAplicacion.getFacturas();
	}

	@GetMapping("/{id}")
	public BillRest getFactura(@PathVariable String id) {
		return facturaAplicacion.getFactura(id);
	}

	@PostMapping
	public void saveFactura(@RequestBody BillRest factura) {
		facturaAplicacion.addFactura(factura);
	}

	@PutMapping
	public void editFactura(@RequestBody BillRest factura) {
		facturaAplicacion.editFactura(factura);
	}

	@DeleteMapping("/{id}")
	public void deleteFactura(@PathVariable String id) {
		facturaAplicacion.deleteFactura(id);
	}

	@DeleteMapping
	public void deleteFacturas() {
		facturaAplicacion.deleteAll();
	}

}
