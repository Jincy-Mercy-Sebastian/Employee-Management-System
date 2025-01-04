package com.jthread.employeemanagement.exception;

public class ResourceNotFoundException extends Exception{
	public ResourceNotFoundException(String string) {
		super("Resourse not found : " + string);
	}

}
