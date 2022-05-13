package com.company.commands;

import com.company.AuxiliaryCommand;

public class Pop implements Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        auxiliary.pop();
    }
}
