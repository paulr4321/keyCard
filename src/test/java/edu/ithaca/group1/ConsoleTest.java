package edu.ithaca.group1;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    void getInputOption() {

        String options = "Jump,Run,Sleep,Eat,Fight";
        Console c = new Console();
        String valid = "3";
        InputStream in = new ByteArrayInputStream(valid.getBytes());

        System.setIn(in);

        int test = Integer.parseInt(valid);

        c.listOptions(options);
        assertEquals(test, c.getInputOption(options), "Incorrect input option");


    }
}