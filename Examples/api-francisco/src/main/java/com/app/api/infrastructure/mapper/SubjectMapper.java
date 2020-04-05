package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Subject;
import com.app.api.infrastructure.dto.SubjectDto;
import com.app.api.infrastructure.rest.SubjectRest;
import com.app.api.shared.domain.Email;
import com.app.api.shared.domain.Phone;
import com.app.api.shared.domain.Id;
import com.app.api.shared.domain.LastName;
import com.app.api.shared.domain.Name;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class SubjectMapper implements MapperDto<SubjectDto, Subject>, MapperRest<SubjectRest, Subject> {

	@Override
	public SubjectRest domRest(Subject o) {

		SubjectRest subject = new SubjectRest();

		subject.setId(o.getId().getId());
		subject.setName(o.getName().getName());
		subject.setLastName(o.getLastName().getLastName());
		subject.setEmail(o.getEmail().getEmail());
		subject.setPhone(o.getPhone().getPhone());
		
		return subject;
		
	}

	@Override
	public Subject restDom(SubjectRest i) {
		return Subject.of(new Id(i.getId()), new Name(i.getName()), new LastName(i.getLastName()), new Email(i.getEmail()), new Phone(i.getPhone()));
	}

	@Override
	public SubjectDto domDto(Subject o) {
		
		SubjectDto subject = new SubjectDto();
		
		subject.setId(o.getId().getId());
		subject.setName(o.getName().getName());
		subject.setLastName(o.getLastName().getLastName());
		subject.setEmail(o.getEmail().getEmail());
		subject.setPhone(o.getPhone().getPhone());
		
		return subject;
		
	}

	@Override
	public Subject dtoDom(SubjectDto i) {
		return Subject.of(new Id(i.getId()), new Name(i.getName()), new LastName(i.getLastName()), new Email(i.getEmail()), new Phone(i.getPhone()));
	}

}
