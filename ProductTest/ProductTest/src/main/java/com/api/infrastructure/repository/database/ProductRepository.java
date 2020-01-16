package com.api.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.infrastructure.dto.ProductDto;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto, String> {

}
