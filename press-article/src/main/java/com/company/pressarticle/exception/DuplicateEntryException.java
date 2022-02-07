package com.company.pressarticle.exception;

public class DuplicateEntryException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DuplicateEntryException() {
		super();
	}
	
	public DuplicateEntryException(String info) {
		super(info);
	}
}
