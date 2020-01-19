package com.app.api.domain.model;

import java.util.List;

import com.app.api.shared.domain.Count;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.TotalPrice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Bill {
	
	private final Count count;
	private final Name name;
	private final List<Item> items;
	private final TotalPrice totalPrice;
		
}
