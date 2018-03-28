package edu.ithaca.group1;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private java.User myUser;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myUser = new java.User();
    }

    @org.junit.jupiter.api.Test
    void setId() {
        String myId = "4";
        myUser.setId("4");
        assertEquals(myId, myUser.getId());

        String myId2 = "";
        myUser.setId(myId2);
        assertEquals(myId2, myUser.getId());

    }

    @org.junit.jupiter.api.Test
    void getId() {
        String myId = "6";
        myUser.setId("6");
        assertEquals(myId, myUser.getId());

        String myId2 = "0";
        myUser.setId("0");
        assertEquals(myId2, myUser.getId());

    }

    @org.junit.jupiter.api.Test
    void setName() {
        String myName = "Jeff";
        myUser.setName(myName);
        assertEquals(myName, myUser.getName());

        String myName2 = "";
        myUser.setName(myName2);
        assertEquals(myName2, myUser.getName());

    }

    @org.junit.jupiter.api.Test
    void getName() {
        String myName = "Ray";
        myUser.setName(myName);
        assertEquals(myName, myUser.getName());

        String myName2 = "";
        myUser.setName(myName2);
        assertEquals(myName2, myUser.getName());
    }




}