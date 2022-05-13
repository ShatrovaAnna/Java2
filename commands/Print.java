package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.EmptyStackException;

public class Print implements Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        if (auxiliary.empty())
            throw new EmptyStackException("Can't print nothing");
        System.out.println(auxiliary.peek());
    }
}
