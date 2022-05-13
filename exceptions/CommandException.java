package com.company.exceptions;

public class CommandException extends RuntimeException{
    public CommandException(String errorMessage){
        super(errorMessage);
    }

}
