package com.company.exceptions;

public class WrongArgumentsExpression extends RuntimeException{

    public WrongArgumentsExpression(String command) {
        super("Command can't parse arguments: " + command);
    }
    public WrongArgumentsExpression(String command, String arguments) {
        super("Command can't parse arguments: " + command + " [ " + arguments + " ]");
    }
}
