package com.app.api.infrastructure.repository.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.api.infrastructure.dto.ItemDto;

@Repository
public interface ItemRepository extends JpaRepository<ItemDto, String>{

}
