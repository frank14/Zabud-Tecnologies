package com.app.api.infrastructure.dto;

import java.util.List;

import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer count;
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemDto> items;
	private Double totalPrice;
	
}
