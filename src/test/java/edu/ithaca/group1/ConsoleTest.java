package edu.ithaca.group1;

import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {

    @Test
    void getInputOption() {

        String options = "Jump,Run,Sleep,Eat,Fight";
        Console c = new Console(options);

        String valid = "3";
        InputStream in = new ByteArrayInputStream(valid.getBytes());
        System.setIn(in);
        int test = Integer.parseInt(valid);
        c.listOptions();
        assertEquals(test, c.getInputOption(), "Incorrect input option");

    }
}