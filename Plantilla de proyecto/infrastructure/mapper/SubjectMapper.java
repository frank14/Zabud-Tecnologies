package com.app.api.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.app.api.domain.model.Subject;
import com.app.api.infrastructure.dto.SubjectDto;
import com.app.api.infrastructure.rest.SubjectRest;
import com.app.api.shared.infrastructure.mapper.MapperDto;
import com.app.api.shared.infrastructure.mapper.MapperRest;

@Component
public class SubjectMapper implements MapperDto<SubjectDto, Subject>, MapperRest<SubjectRest, Subject> {
	
	@Override
	public SubjectRest domRest(Subject o) {

		SubjectRest subject = new SubjectRest();
		
		subject.setCode(o.getCode().getCode());
		subject.setCredits(o.getCredits().getCredit());
		subject.setName(o.getName().getName());
		
		return subject;
	}

	@Override
	public Subject restDom(SubjectRest i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubjectDto domDto(Subject o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Subject dtoDom(SubjectDto i) {
		// TODO Auto-generated method stub
		return null;
	}
}
