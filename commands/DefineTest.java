package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.*;

public class DefineTest {
    @Test
    public void execute() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("DEFINE");
        auxiliary.add("AVG", 1.0);
        command.execute(auxiliary, "AVG 3.0");
        Assert.assertEquals(3.0, auxiliary.get("AVG"), 0.00001);
    }
}