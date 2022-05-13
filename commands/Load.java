package com.company.commands;
import com.company.AuxiliaryCommand;
import com.company.exceptions.WrongArgumentsExpression;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Load implements Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {

        int currentIndex = 0;

        while ((currentIndex < parameters.length()) && !Character.isWhitespace(parameters.charAt(currentIndex)))
            currentIndex++;

        Scanner reader = null;
        try
        {

            reader = new Scanner(new File(parameters.substring(0,currentIndex))).useDelimiter("\\s").useLocale(Locale.ENGLISH);
            while (reader.hasNext()) {
                if (reader.hasNextDouble())
                    auxiliary.push(reader.nextDouble());
                else
                    reader.next();
            }

        }
        catch (IOException e)
        {
            throw  new WrongArgumentsExpression("Load", parameters);
        }
        finally
        {
            if (null != reader)
            {
                reader.close();
            }
        }

    }
}
