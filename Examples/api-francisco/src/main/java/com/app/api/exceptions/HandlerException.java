package com.app.api.exceptions;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.java.Log;

@RestControllerAdvice
@Log
public class HandlerException {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorCode generalException(Exception e) {

		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	@ExceptionHandler(IdException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode idException(IdException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}
	
	@ExceptionHandler(NameException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode nameException(NameException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}
	
	@ExceptionHandler(LastNameException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode lastNameException(LastNameException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}
	
	@ExceptionHandler(EmailException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode EmailException(EmailException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}
	
	@ExceptionHandler(PhoneException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode PhoneException(PhoneException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	public String generateId() {
		return UUID.randomUUID().toString();
	}

	public void generateLog(Exception e, ErrorCode ec) {

		log.severe(e.getMessage());
		log.severe(ec.getMessage());
		log.severe(ec.getCode());
		
	}
	
}
