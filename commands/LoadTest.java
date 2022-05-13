package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoadTest {

    @Test
    public void execute() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("LOAD");
        command.execute(auxiliary, "C:\\Users\\X390\\IdeaProjects\\untitled\\src\\com\\company\\commands\\test.txt");
        Assert.assertEquals(new ArrayList<>(List.of(-4.5, 2.5)), auxiliary.getStack());
    }
}