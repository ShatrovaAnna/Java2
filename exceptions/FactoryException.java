package com.company.exceptions;

public class FactoryException extends RuntimeException{
    public FactoryException(String errorMessage){
        super(errorMessage);
    }
}
