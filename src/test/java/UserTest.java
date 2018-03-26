package java;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User myUser;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        myUser = new User();
    }

    @org.junit.jupiter.api.Test
    void setId() {
        int myId = 4;
        myUser.setId(4);
        assertEquals(myId, myUser.getId());

        int myId2 = 0;
        myUser.setId(0);
        assertEquals(myId2, myUser.getId());

    }

    @org.junit.jupiter.api.Test
    void getId() {
        int myId = 6;
        myUser.setId(6);
        assertEquals(myId, myUser.getId());

        int myId2 = 0;
        myUser.setId(0);
        assertEquals(myId2, myUser.getId());

    }

    @org.junit.jupiter.api.Test
    void setName() {
        String myName = "Jeff";
        myUser.setName(myName);
        assertEquals(myName, myUser.getName());

        String myName2 = "";
        myUser.setName(myName);
        assertEquals(myName2, myUser.getName());

    }

    @org.junit.jupiter.api.Test
    void getName() {
        String myName = "Ray";
        myUser.setName(myName);
        assertEquals(myName, myUser.getName());

        String myName2 = "";
        myUser.setName(myName);
        assertEquals(myName2, myUser.getName());
    }




}