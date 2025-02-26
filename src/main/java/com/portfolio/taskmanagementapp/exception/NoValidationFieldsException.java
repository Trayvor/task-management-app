package com.portfolio.taskmanagementapp.exception;

public class NoValidationFieldsException extends RuntimeException {
    public NoValidationFieldsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
