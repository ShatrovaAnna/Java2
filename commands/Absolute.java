package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.EmptyStackException;

public class Absolute implements  Command{

        @Override
        public void execute(AuxiliaryCommand auxiliary, String parameters) {

            if (auxiliary.empty()) {
                throw new EmptyStackException("absolute");
            }
            Double value = auxiliary.pop();
            auxiliary.push(Math.abs(value));
    }
}
