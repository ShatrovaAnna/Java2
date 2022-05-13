package com.company.commands;

import com.company.AuxiliaryCommand;
import com.company.CommandFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class SaveTest {

    @Test
    public void execute() throws FileNotFoundException {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Command command = CommandFactory.getInstance().createCommand("SAVE");
        auxiliary.push(2.0);
        auxiliary.push(3.0);
        command.execute(auxiliary, "C:\\Users\\X390\\IdeaProjects\\untitled\\src\\com\\company\\commands\\out.txt");
        Double [] elem = new Double[2];
        elem[0] = 2.0;
        elem[1] = 3.0;
        Double [] elem1;
        elem1 = read();
        Assert.assertArrayEquals(elem1, elem);

    }
    private Double[] read() throws FileNotFoundException {
        Double[] elements = new Double[2];
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\X390\\IdeaProjects\\untitled\\src\\com\\company\\commands\\out.txt")));){
        for (int i = 0; i <2; i++) {
                elements[i] = Double.parseDouble(reader.readLine());
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }
}