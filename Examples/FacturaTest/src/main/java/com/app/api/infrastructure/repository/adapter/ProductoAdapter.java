package com.app.api.infrastructure.repository.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Product;
import com.app.api.domain.service.ProductoService;
import com.app.api.exceptions.RegisterNotFoundException;
import com.app.api.infrastructure.dto.ProductDto;
import com.app.api.infrastructure.mapper.ProductoMapper;
import com.app.api.infrastructure.repository.database.ProductoRepository;

@Service
public class ProductoAdapter implements ProductoService {

	@Autowired
	ProductoRepository productoRepository;

	@Autowired
	ProductoMapper productoMapper;

	@Override
	public List<Product> buscarPorIds(List<String> codigos) {
		return productoRepository.findAllById(codigos.stream().map(codigo -> codigo).collect(Collectors.toList()))
				.stream().map(producto -> productoMapper.transformarDtoParaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void guardar(Product product) {
		productoRepository.save(productoMapper.transformarDominioParaDto(product));
	}

	@Override
	public void editar(Product product) {
		this.buscarPorId(product.getId().getValue());
		productoRepository.save(productoMapper.transformarDominioParaDto(product));
	}

	@Override
	public Product buscarPorId(String id) {
		return productoMapper.transformarDtoParaDominio(
				productoRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException()));
	}

	@Override
	public List<Product> buscarTodos() {
		return productoRepository.findAll().stream().map(producto -> productoMapper.transformarDtoParaDominio(producto))
				.collect(Collectors.toList());
	}

	@Override
	public void eliminarPorId(String id) {
		ProductDto producto = productoRepository.findById(id).orElseThrow(() -> new RegisterNotFoundException());
		productoRepository.deleteById(producto.getId());
	}

}
