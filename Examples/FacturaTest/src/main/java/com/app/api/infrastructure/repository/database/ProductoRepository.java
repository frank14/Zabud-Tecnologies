package com.app.api.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.infrastructure.dto.ProductDto;

@Repository
public interface ProductoRepository extends JpaRepository<ProductDto, String> {

	public ProductDto findByNombre(String nombre);
	public ProductDto findByValor(Double valor);
	
}
