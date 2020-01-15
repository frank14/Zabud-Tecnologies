package com.app.api.infrastructure.rest;

import lombok.Data;

@Data
public class SubjectRest {
	
	private String name;
	private String code;
	private Integer credits;
	public void setCredits(Integer credit) {
		// TODO Auto-generated method stub
		
	}
	
}
