package org.example.exception;

public class UserNotFoundException extends WorkApiException {
    private static final String MESSAGE = "The user specified is not found!";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
