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

	@ExceptionHandler(CodeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode codeException(CodeException e) {

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

	@ExceptionHandler(IdException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode idException(IdException e) {
		
		ErrorCode ec = new ErrorCode();
		ec.setCode(generateId());
		ec.setMessage(e.getMessage());
		generateLog(e, ec);
		return ec;
		
	}

	@ExceptionHandler(CreditException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode creditException(CreditException e) {
		
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
