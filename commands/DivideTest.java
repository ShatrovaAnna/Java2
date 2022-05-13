package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class DivideTest {

    @Test
    public void execute() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("/");
        auxiliary.push(6.0);
        auxiliary.push(2.0);
        command.execute(auxiliary, "");
        Assert.assertEquals(new ArrayList<>(List.of(3.0)), auxiliary.getStack());
    }
}