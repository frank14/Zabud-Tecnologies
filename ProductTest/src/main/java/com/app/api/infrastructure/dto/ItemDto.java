package com.app.api.infrastructure.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
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
@Table(name = "items")
public class ItemDto extends BaseEntity {
	
	private Integer count;
	@OneToOne
	private ProductDto product;
	private Double totalPrice;
	
}
