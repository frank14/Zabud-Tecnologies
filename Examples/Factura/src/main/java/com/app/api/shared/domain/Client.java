package com.app.api.shared.domain;

import com.app.api.exceptions.ClientException;

import lombok.Getter;

public class Client {
	
	@Getter
	private final String client;

	public Client(String value) {
		
		try {
			this.client = value;
						
			if (!value.matches("[A-Z].*")) {
				throw new ClientException();
			}
			
		} catch (NullPointerException e) {
			throw new ClientException();
		}
		
	}
	
}
