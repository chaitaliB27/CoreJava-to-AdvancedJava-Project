package com.hms.Exception;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private HttpStatus status;
	private String message ;
	HttpStatus getStatus() {
		return status;
	}
	void setStatus(HttpStatus status) {
		this.status = status;
	}
	String getMessage() {
		return message;
	}
	void setMessage(String message) {
		this.message = message;
	}
	public ErrorMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
}
