package com.portfolio.authservice.exception;

public class NoValidationFieldsException extends RuntimeException {
    public NoValidationFieldsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
