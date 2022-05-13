package com.company;

import com.company.exceptions.EmptyStackException;
import java.util.*;

public class AuxiliaryCommand {
    private final Map<String, Double> value = new HashMap<>();
    private final Stack<Double> stack = new Stack<>();

    public void push(Double value){
        stack.push(value);
    }

    public Double pop(){
        try {
            Double temp = stack.pop();
            return temp;
        } catch (NoSuchElementException e) {
            throw new EmptyStackException("Stack is empty");
        }
    }

    public Double peek(){
        Double temp = stack.lastElement();
        if (temp == null) {
            throw new EmptyStackException("stack is empty");
        } else {
            return temp;
        }
    }

    public void add(String name, Double temp){
        value.put(name, temp);
    }

    public Double get(String name){
        return value.get(name);
    }

    public void delete(String name) {
        value.remove(name);
    }

    public List<Double> getStack(){
        return Collections.unmodifiableList(stack);
    }

    public int size(){
        return stack.size();
    }

    public boolean empty(){
        return stack.empty();
    }
}
