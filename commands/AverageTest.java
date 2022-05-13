package com.company.commands;
import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.*;
import java.util.*;

public class AverageTest {
    @Test
    public void execute() {

        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("AVG");

        auxiliary.push(5.3);
        auxiliary.push(4.1);
        auxiliary.push(6.5);
        command.execute(auxiliary, "3");

        Assert.assertEquals(new ArrayList<>(List.of(5.3)), auxiliary.getStack());
    }
}
