package com.company.exceptions;

public class LoadPropertiesException extends RuntimeException{

    public LoadPropertiesException(String errorMessage) {
        super(errorMessage);
    }
    public LoadPropertiesException(String errorMessage, Throwable exception) {
        super(errorMessage,exception);
    }
}
