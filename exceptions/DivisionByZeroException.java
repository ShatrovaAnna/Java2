package com.company.exceptions;

public class DivisionByZeroException extends ArithmeticalException{
        public DivisionByZeroException() {
            super("You can't divide by zero!");
        }
}
