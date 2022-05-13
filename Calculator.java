package com.company;

import com.company.commands.Command;
import com.company.exceptions.ArithmeticalException;
import com.company.exceptions.CommandException;
import com.company.exceptions.FactoryException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.*;

public class Calculator {

    private static final Logger log = Logger.getLogger(Calculator.class.getName());

    public void run(String[] args) {

        try {
            log.setUseParentHandlers(false);
            FileHandler fh = new FileHandler("src/log.txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            log.addHandler(fh); //???

        } catch (IOException e) {
            e.printStackTrace();
        }

        Calculator calculator = new Calculator();
        log.info("Calculator created");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        if (args.length > 0){ // Заморочка с проверкой?
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
                log.info("Opened file: \"" + args[0] +"\"");
            } catch (FileNotFoundException e) {
                log.info("Error opening file: \"" + args[0] +"\". Will reading System.in");
            }
        }
        calculator.calculate(reader);
    }

    public void calculate(BufferedReader reader) {

        try{
            String line;
            line = reader.readLine();
            while (line != null) {
                parserCommand(line);
                line = reader.readLine();
            }
        }
        catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException exception) {
            log.info("Error: problem with reading stream");
        }
        finally {
            if (null != reader)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    log.warning(e.getMessage());
                }
            }
        }
    }

    private final AuxiliaryCommand auxiliary = new AuxiliaryCommand();

    private void parserCommand(String line) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        int currentIndex = 0;

        while ((currentIndex < line.length()) && !Character.isWhitespace(line.charAt(currentIndex))) {
            currentIndex++;
        }
        String commandName = line.substring(0, currentIndex++);

        String commandParameters = "";
        if (currentIndex < line.length()) {
            commandParameters = line.substring(currentIndex);
        }
        Command command;

        try {
            command = CommandFactory.getInstance().createCommand(commandName);
        }
        catch (FactoryException e){
            log.warning("Problem with CommandFactory: " + e.getMessage());
            return;
        }

        try{
            command.execute(auxiliary, commandParameters);
            log.info("Successful command: " + commandName);
        }
        catch (ArithmeticalException e){
            log.warning("Arithmetical Exception: " + e.getMessage());
        }
        catch (CommandException e){
            log.warning("Command Exception: " + e.getMessage());
        }
    }
}
