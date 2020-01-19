package com.app.api.domain.model;

import com.app.api.shared.domain.Count;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Price;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Item {
	
	private final Id id;
	private final Count count;
	private final Product product;
	private final Price totalPrice;
		
}
