package com.company.exceptions;

public class NoSuchCommandException  extends RuntimeException{
    public NoSuchCommandException(String command) {
        super("Command not found: " + command);
    }
}
