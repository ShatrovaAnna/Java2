package com.company.commands;

import com.company.AuxiliaryCommand;

public interface Command {
        void execute(AuxiliaryCommand auxiliary, String parameters);
}
