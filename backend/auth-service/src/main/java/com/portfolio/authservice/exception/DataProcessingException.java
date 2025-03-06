package com.portfolio.authservice.exception;

public class DataProcessingException extends RuntimeException {
    public DataProcessingException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public DataProcessingException(String message) {
        super(message);
    }
}
