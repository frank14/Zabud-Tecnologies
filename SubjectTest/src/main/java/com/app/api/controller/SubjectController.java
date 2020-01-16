package com.app.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.api.application.SubjectApplication;
import com.app.api.domain.service.SubjectService;
import com.app.api.infrastructure.dto.SubjectDto;
import com.app.api.infrastructure.mapper.SubjectMapper;
import com.app.api.infrastructure.rest.SubjectRest;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	SubjectApplication subjectApplication;

	public SubjectController(@Autowired SubjectMapper subjectMapper, @Autowired SubjectService subjectService) {
		this.subjectApplication = new SubjectApplication(subjectMapper, subjectService);
	}

	@GetMapping
	public List<SubjectRest> getSubject() {
		return subjectApplication.getAll();
	}

	@GetMapping("/{id}")
	public SubjectRest getSubject(@PathVariable String id) {
		return subjectApplication.findSubject(id);
	}
	
	//@RequestMapping(value="/saveSubject", method=RequestMethod.POST)
	@PostMapping("/saveSubject")
	public SubjectRest saveSubject(@RequestBody SubjectRest subject) {
		return subjectApplication.save(subject);
	}
	/*
	//@RequestMapping(value="/updateSubject", method=RequestMethod.PUT)
	@PutMapping("/updateSubject")
	public SubjectRest updateSubject(@RequestBody SubjectRest subject) {
		return subjectApplication.update(subject);
	}
	*/
	// FIXED: Arreglando metodo update busca el subject pero no actualiza realmente
	@PutMapping("/updateSubject/{id}")
	public SubjectRest updateSubject(@PathVariable String id, @RequestBody SubjectRest subject) {
		SubjectRest returnValue = new SubjectRest();
		
		SubjectDto subjectDto = new SubjectDto();
        BeanUtils.copyProperties(subject, subjectDto);
        
        SubjectDto updatedSubjectDetails = subjectApplication.updateSubject(subjectDto, id);
        BeanUtils.copyProperties(updatedSubjectDetails, returnValue);
        
        return returnValue;
	}

	//@RequestMapping(value="/deleteSubject", method=RequestMethod.DELETE)
	@DeleteMapping("/deleteSubject/{id}")
	public void deleteSubject(@PathVariable String id) {
		subjectApplication.delete(id);
	}

}
