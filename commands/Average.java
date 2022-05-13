package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.exceptions.EmptyStackException;
import com.company.exceptions.WrongArgumentsExpression;

public class Average implements Command {

    @Override
    public void execute(AuxiliaryCommand auxiliary, String parameters) {

        int n = 0;

        if (0 < parameters.length()) {
            try {
                n = Integer.parseInt(parameters.replaceAll("[^0-9]", ""));
            }
            catch (NumberFormatException e){
                throw new WrongArgumentsExpression("Average", parameters);
            }
        }
        if (n <= 0)
            throw new WrongArgumentsExpression("Average", parameters);

        if (auxiliary.size() < n)
            throw new EmptyStackException("Average can't work");

        double sum = 0;

        for (int i = 0; i < n; ++i){
            sum += auxiliary.pop();
        }

        auxiliary.push(sum / n);
    }
}
