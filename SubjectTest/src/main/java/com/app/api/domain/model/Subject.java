package com.app.api.domain.model;

import com.app.api.shared.domain.Code;
import com.app.api.shared.domain.Credit;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.Name;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Subject {
	
	private final Id id;
	private final Code code;
	private final Name name;
	private final Credit credit;

	public static Subject of(Id id, Code code, Name name, Credit credit) {
		return new Subject(id, code, name, credit);
	}
	
}
