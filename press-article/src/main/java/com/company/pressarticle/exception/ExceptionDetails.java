package com.company.pressarticle.exception;

import java.time.LocalDateTime;

public class ExceptionDetails {

	private String message;
	private int status;
	private LocalDateTime time;
	
	public ExceptionDetails() {
		
	}
	
	public ExceptionDetails(String message, int status, LocalDateTime time) {
		super();
		this.message = message;
		this.status = status;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
}
