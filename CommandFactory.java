package com.company;

import com.company.commands.Command;
import com.company.exceptions.NoSuchCommandException;
import com.company.exceptions.LoadPropertiesException;

import java.util.Properties;

public class CommandFactory {
    private static volatile CommandFactory instance;

    private final Properties properties = new Properties();

    private CommandFactory() {
        try {
            properties.load(CommandFactory.class.getResourceAsStream("config.properties"));
        }
        catch (Exception e) {
            throw new LoadPropertiesException("Problem with load properties file");
        }
    }

    public static CommandFactory getInstance(){
        if (instance == null) {
            synchronized (CommandFactory.class) {
                if (instance == null) {
                    instance = new CommandFactory();
                }
            }
        }
        return instance;
    }

    public Command createCommand(String commandName)
    {

        String commandClassName = properties.getProperty(commandName);
        if (commandClassName == null)
            throw new NoSuchCommandException(commandName);

        Command command;
        try {
            Class<?> commandClass = Class.forName(commandClassName);
            command = (Command) commandClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new NoSuchCommandException(commandName);
        }
        return command;
    }
}
