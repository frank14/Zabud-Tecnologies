package com.app.api.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class BillDto extends BaseEntity {
	
	private String client;
	@OneToMany(targetEntity = ItemDto.class, cascade = CascadeType.ALL)
	private List<ItemDto> items;
	private Double totalPrice;
	
}
