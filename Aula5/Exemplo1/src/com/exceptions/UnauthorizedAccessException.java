package com.exceptiondemo.exceptions;

public class UnauthorizedAccessException extends Exception {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}
