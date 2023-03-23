package com.info.crud.payloads;

public class ApiResponse {
	
	String message;
	Boolean flag;
	public ApiResponse(String message, Boolean flag) {
		super();
		this.message = message;
		this.flag = flag;
	}
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
