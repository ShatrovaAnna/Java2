package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.Assert;
import java.util.*;

public class AbsoluteTest {
    @org.junit.Test
    public void execute() {

        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("ABS");

        auxiliary.push(-5.3);
        command.execute(auxiliary, "");
        auxiliary.push(1.3);
        command.execute(auxiliary, "");
        Assert.assertEquals(new ArrayList<>(List.of(5.3, 1.3)), auxiliary.getStack());
    }
}
