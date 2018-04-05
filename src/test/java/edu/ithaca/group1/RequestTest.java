package edu.ithaca.group1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {
    Request testRequest0;
    Request testRequest1;
    Request testRequest2;
    Request testRequest3;

    @BeforeEach
    void setUp() {
        testRequest0 = new Request("11111", "0");
        testRequest1 = new Request("", "");
        testRequest2 = new Request("00000", "1");
        testRequest3 = new Request("43210", "10");
    }

    @Test
    void getUserId() {
        assertEquals("11111", testRequest0.getUserId());
        assertEquals("", testRequest1.getUserId());
        assertEquals("00000", testRequest2.getUserId());
        assertEquals("43210", testRequest3.getUserId());
    }

    @Test
    void getDoorId() {
        assertEquals("0", testRequest0.getDoorId());
        assertEquals("", testRequest1.getDoorId());
        assertEquals("1", testRequest2.getDoorId());
        assertEquals("10", testRequest3.getDoorId());
    }

}