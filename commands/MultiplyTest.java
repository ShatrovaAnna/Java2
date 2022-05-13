package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MultiplyTest {

    @Test
   public void execute() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("*");
        auxiliary.push(6.0);
        auxiliary.push(2.0);
        command.execute(auxiliary, "");
        Assert.assertEquals(new ArrayList<>(List.of(12.0)), auxiliary.getStack());
    }
}