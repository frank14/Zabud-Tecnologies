package com.app.api.domain.model;

import com.app.api.shared.domain.Code;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Price;
import com.app.api.shared.domain.Name;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Product {
	
	private final Id id;
	private final Code code;
	private final Name name;
	private final Price price;
	
}
