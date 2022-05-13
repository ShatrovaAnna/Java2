package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommentTest {

    @Test
    public void execute() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("/#");
        auxiliary.add("#", 5.3);
        command.execute(auxiliary, "");
        Assert.assertTrue(auxiliary.empty());
    }
}