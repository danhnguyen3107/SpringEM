package com.code.project.projectv1.exception;


public class UserNotFountException extends RuntimeException {
    public UserNotFountException(String message) {
        super(message);
    }

    public UserNotFountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFountException(Throwable cause) {
        super(cause);
    }
}
