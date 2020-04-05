package com.app.api.events.internal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.app.api.events.EventSubject;
import com.app.api.infrastructure.rest.SubjectRest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultEventSubject implements EventSubject {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Value("${message.outbound.franciscoInBound}")
	private String franciscoInBound;

	@Override
	public void publishSubject(SubjectRest subjectRest) {
		try {
			jmsTemplate.convertAndSend(franciscoInBound, mapper.writeValueAsString(franciscoInBound));
		} catch (JsonProcessingException ex) {
			log.error(String.format("jms send. Exception convert object to json: [%s]", ex.getMessage()));
		}
		
	}

}
