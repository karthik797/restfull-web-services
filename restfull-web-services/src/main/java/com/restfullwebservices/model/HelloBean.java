package com.restfullwebservices.model;

public class HelloBean {

	private String message="Hello Bean";

	public HelloBean(String message) {
		super();
		this.message = message;
	}
	
	public HelloBean() {		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
