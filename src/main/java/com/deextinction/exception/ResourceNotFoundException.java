package com.deextinction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -3510175088574375864L;

    public ResourceNotFoundException() {
        super();
    }

    /**
     * Constructor that accepts a custom error message.
     * 
     * @param message the custom error message.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor that accepts a custom error message and a cause.
     * 
     * @param message the custom error message.
     * @param cause   the cause of the exception.
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
