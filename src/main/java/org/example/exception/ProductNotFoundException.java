package org.example.exception;

public class ProductNotFoundException extends  WorkApiException{
    private static final String MESSAGE = "The product specified is not found!";

    public ProductNotFoundException() {
        super(MESSAGE);
    }
}
