package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.WrongArgumentsExpression;

public class Define implements Command{
    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {
        int currentIndex = 0;

        while ((currentIndex < parameters.length()) && !Character.isWhitespace(parameters.charAt(currentIndex)))
            currentIndex++;

        String variableName = parameters.substring(0,currentIndex++);

        double variableValue;
        if (currentIndex < parameters.length()) {
            try{
                variableValue = Double.parseDouble(parameters.substring(currentIndex).replaceAll(",", ".").replaceAll("[^0-9.-]", ""));
            }
            catch (NumberFormatException e){
                throw new WrongArgumentsExpression("Define", parameters);
            }
        }
        else{
            throw new WrongArgumentsExpression("Define", parameters);
        }
        auxiliary.add(variableName, variableValue);
    }
}
