package com.app.api.infrastructure.repository.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.domain.model.Subject;
import com.app.api.domain.service.SubjectService;
import com.app.api.events.EventSubject;
import com.app.api.infrastructure.mapper.SubjectMapper;
import com.app.api.infrastructure.repository.database.SubjectRepository;
import com.app.api.shared.domain.Id;

@Service
public class SubjectAdapter implements SubjectService {
	
	@Autowired
	private EventSubject eventSubject;
	
	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	SubjectMapper subjectMapper;
	
	@Override
	public Subject saveSubject(Subject subject) {
		Subject dominio = subjectMapper.dtoDom(subjectRepository.save(subjectMapper.domDto(subject)));
		this.publishSubject(dominio);
		return dominio;
	}

	@Override
	public Subject getSubject(Id id) {
		return subjectMapper.dtoDom(subjectRepository.findById(id.getId()).orElseThrow(() -> new RuntimeException()));
	}

	@Override
	public List<Subject> getSubjects() {
		return subjectMapper.listDtoDom(subjectRepository.findAll());
	}

	@Override
	public Subject updateSubject(Subject subject, Id id) {
		Subject findSubject = getSubject(id);
		saveSubject(subject);
		return findSubject;
	}

	@Override
	public void deleteSubject(Id id) {
		subjectRepository.deleteById(id.getId());
	}

	@Override
	public void publishSubject(Subject subject) {
		eventSubject.publishSubject(subjectMapper.domRest(subject));
	}

}
