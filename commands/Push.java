package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.WrongArgumentsExpression;

public class Push implements Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        int currentIndex = 0;

        while ((currentIndex < parameters.length()) && !Character.isWhitespace(parameters.charAt(currentIndex)))
            currentIndex++;

        Double value;
        if (Character.isAlphabetic(parameters.charAt(0))) {
            value = auxiliary.get(parameters.substring(0, currentIndex));
        }
        else {
            try {
                value = Double.parseDouble(parameters.substring(0, currentIndex).replaceAll(",", ".").replaceAll("[^0-9.-]", ""));
            }
            catch (NumberFormatException e){
                throw new WrongArgumentsExpression(parameters.substring(0, currentIndex));
            }
        }
        auxiliary.push(value);
    }
}
