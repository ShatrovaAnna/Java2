package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.CommandException;
import com.company.exceptions.WrongArgumentsExpression;

import java.io.*;

public class Save implements Command {
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        int currentIndex = 0;

        while ((currentIndex < parameters.length()) && !Character.isWhitespace(parameters.charAt(currentIndex)))
            currentIndex++;

        Writer writer = null;
        try {
            writer = new OutputStreamWriter(new FileOutputStream(parameters.substring(0, currentIndex)));
            for (Double i : auxiliary.getStack()) {
                writer.write(i.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new WrongArgumentsExpression("Save", parameters);
        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new CommandException("Error with writing and saving");
                }
            }
        }
    }
}
