package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.EmptyStackException;

public class Multiply implements  Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        if (auxiliary.size() < 2)
            throw new EmptyStackException("Not enough args for minus");

        Double value2 = auxiliary.pop();

        Double value1 = auxiliary.pop();

        auxiliary.push(value1 * value2);
    }
}
