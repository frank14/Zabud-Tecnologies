package com.app.api.domain.model;

import com.app.api.shared.domain.Email;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.LastName;
import com.app.api.shared.domain.Name;
import com.app.api.shared.domain.Phone;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(staticName = "of")
public class Subject {
	
	private final Id id;
	private final Name name;
	private final LastName lastName;
	private final Email email;
	private final Phone phone;

}
