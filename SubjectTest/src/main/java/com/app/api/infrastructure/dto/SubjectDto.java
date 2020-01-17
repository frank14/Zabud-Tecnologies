package com.app.api.infrastructure.dto;

import javax.persistence.Entity;
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
@Table(name = "subjects")
public class SubjectDto extends BaseEntity {

	private String code;
	private String name;
	private Integer credit;
	
}
