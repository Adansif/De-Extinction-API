package com.deextinction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Annotation to define the HTTP status to be returned when this exception is thrown
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	// This class represents a custom exception to be used for resource not found errors.
	// It extends RuntimeException, which is an unchecked exception.

	// A unique identifier for Serializable classes
	private static final long serialVersionUID = -3510175088574375864L;

	// Default constructor
	public ResourceNotFoundException() {
		super(); // Calls the constructor of the superclass (RuntimeException)
	}
	
	// Constructor that accepts a custom error message
	public ResourceNotFoundException(String message) {
		super(message); // Calls the constructor of the superclass with the error message
	}
	
	// Constructor that accepts a custom error message and a cause (another throwable)
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause); // Calls the constructor of the superclass with the error message and cause
	}
}
