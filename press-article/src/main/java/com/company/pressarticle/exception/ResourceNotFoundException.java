package com.company.pressarticle.exception;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException() {
	super();
	}

	public ResourceNotFoundException(String info) {
	super(info);
	}

}
