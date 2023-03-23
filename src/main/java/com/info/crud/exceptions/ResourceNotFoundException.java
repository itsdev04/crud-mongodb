package com.info.crud.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	Integer id;
	String name;
	
	public ResourceNotFoundException(Integer id, String name){
		super(String.format("%d is not found with %s name"));
		this.id = id;
		this.name = name;
	}
}
