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

import com.app.api.application.ProductoAplicacion;
import com.app.api.domain.service.ProductoService;
import com.app.api.infrastructure.mapper.ProductoMapper;
import com.app.api.infrastructure.rest.ProductRest;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	ProductoAplicacion productoAplicacion;

	public ProductoController(@Autowired ProductoService productoService, @Autowired ProductoMapper productoMapper) {
		this.productoAplicacion = new ProductoAplicacion(productoService, productoMapper);
	}

	@GetMapping
	public List<ProductRest> getProductos() {
		return productoAplicacion.listar();
	}

	@GetMapping("/{id}")
	public ProductRest getProducto(@PathVariable String id) {
		return productoAplicacion.buscar(id);
	}

	@PostMapping
	public void save(@RequestBody ProductRest producto) {
		productoAplicacion.crear(producto);
	}

	@PutMapping
	public void edit(@RequestBody ProductRest producto) {
		productoAplicacion.actualizar(producto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		productoAplicacion.eliminar(id);
	}

}
