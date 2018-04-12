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
        testRequest0 = new Request("1","11111", "0");
        testRequest1 = new Request("2", "", "", RequestStatus.SECURITY_CLEARED);
        testRequest2 = new Request("3","00000", "1", RequestStatus.ADDED);
        testRequest3 = new Request("4","43210", "10", RequestStatus.DENIED);
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

    @Test
    void getId() {
        assertEquals("1", testRequest0.getId());
        assertEquals("2", testRequest1.getId());
        assertEquals("3", testRequest2.getId());
        assertEquals("4", testRequest3.getId());
    }

    @Test
    void getStatus() {
        assertEquals(RequestStatus.NEW, testRequest0.getStatus());
        assertEquals(RequestStatus.SECURITY_CLEARED, testRequest1.getStatus());
        assertEquals(RequestStatus.ADDED, testRequest2.getStatus());
        assertEquals(RequestStatus.DENIED, testRequest3.getStatus());
    }

    @Test
    void setStatus() {
        testRequest0.setStatus(RequestStatus.SECURITY_CLEARED);
        assertEquals(RequestStatus.SECURITY_CLEARED, testRequest0.getStatus());
    }
}