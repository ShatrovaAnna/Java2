package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.DivisionByZeroException;
import com.company.exceptions.EmptyStackException;

public class Divide implements Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        if (auxiliary.size() < 2)
            throw new EmptyStackException("Divide");

        if (auxiliary.peek() == 0.)
            throw new DivisionByZeroException();

        Double value2 = auxiliary.pop();

        Double value1 = auxiliary.pop();

        auxiliary.push(value1 / value2);
    }
}
