package com.app.api.events;

import com.app.api.infrastructure.rest.SubjectRest;

public interface EventSubject {

	public void publishSubject(SubjectRest subjectRest);
	
}
