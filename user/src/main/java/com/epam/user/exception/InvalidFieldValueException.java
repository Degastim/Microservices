package com.epam.user.exception;

public class InvalidFieldValueException extends RuntimeException {
    public InvalidFieldValueException(String message) {
        super(message);
    }
}
