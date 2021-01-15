package org.example.exception;

public class WorkApiException extends Exception{
    private static final String MESSAGE = "Generic work api not found";

    public WorkApiException(){
        super(MESSAGE);
    }
    public WorkApiException(String message){
        super(message);
    }
}
