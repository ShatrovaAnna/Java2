package com.company;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuxiliaryCommandTest {

    @org.junit.jupiter.api.Test
    void push() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        auxiliary.push(5.3);
        auxiliary.push(0.01);
        Assert.assertEquals(new ArrayList<>(List.of(5.3, 0.01)), auxiliary.getStack());
    }

    @org.junit.jupiter.api.Test
    void pop() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        auxiliary.push(5.3);
        auxiliary.push(1.3);
        auxiliary.pop();
        Assert.assertEquals(new ArrayList<>(List.of(5.3)), auxiliary.getStack());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        auxiliary.push(5.3);
        auxiliary.push(-1.2);
        Assert.assertEquals(-1.2, auxiliary.peek(), 0.000001);
    }

    @org.junit.jupiter.api.Test
    void add() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Assert.assertNull(auxiliary.get("Test"));
    }

    @org.junit.jupiter.api.Test
    void get() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        auxiliary.add("Test", 5.3);
        Assert.assertNotNull(auxiliary.get("Test"));
        Assert.assertEquals(5.3, auxiliary.get("Test"), 0.00001);
    }

    @org.junit.jupiter.api.Test
    void size() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        auxiliary.push(5.3);
        Assert.assertEquals(1, auxiliary.size());

    }

    @org.junit.jupiter.api.Test
    void empty() {
        AuxiliaryCommand auxiliary = new AuxiliaryCommand();
        Assert.assertTrue(auxiliary.empty());
        auxiliary.push(5.3);
        Assert.assertFalse(auxiliary.empty());
    }
}