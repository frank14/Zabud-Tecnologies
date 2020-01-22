package com.app.api.domain.model;

import java.util.List;

import com.app.api.shared.domain.Client;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.TotalPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Bill {
	
	private final Id id;
	private final Client client;
	private final List<Item> items;
	private final TotalPrice totalPrice;
		
}
