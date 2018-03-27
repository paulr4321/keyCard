package edu.ithaca.group1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoorTest
{

    @Test
    void getInfo()
    {

        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};

        Door testDoor = new Door("0", testUsers);

        for (int i = 0; i < testUsers.length; i++) {
            String expected = "UserId: " + testUsers[i] + "\nName: Unknown";

            assertEquals(expected, testDoor.getInfo(testUsers[i]), "User Info for user: " + testUsers[i] + "Incorrect");
        }
    }

    @Test
    void checkUserAccessExceptionTest()
    {
        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};
        String[] invalidUsers = new String[]{"#0000", "00a00", "1100000", "aaaaa", "", "123456789", "00 00"};

        Door testDoor = new Door("0", testUsers);

        boolean exceptionCaught = false;

        for (int i = 0; i < invalidUsers.length; i++)
        {
            exceptionCaught = false;
            try
            {
                testDoor.checkUserAccess(invalidUsers[i]);
            }
            catch (Exception e)
            {
                exceptionCaught = true;
            }
            if (!exceptionCaught)
            {
                fail("Exception not thrown for invalid ID");
            }
        }
    }


    @Test
    void checkUserAccess()
    {
        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};

        Door testDoor = new Door("0", testUsers);

        boolean exceptionCaught = false;

        try {
            for (int i = 0; i < testUsers.length; i++) {

                assertEquals(true, testDoor.checkUserAccess(testUsers[i]), "Access permissions incorrect");
                assertEquals(true, testDoor.opened, "Door not opened for valid ID");
            }

            assertEquals(false, testDoor.checkUserAccess("11111"), "Access permissions incorrect");
            assertEquals(false, testDoor.checkUserAccess("60879"), "Access permissions incorrect");
            assertEquals(false, testDoor.checkUserAccess("30929"), "Access permissions incorrect");
            assertEquals(false, testDoor.checkUserAccess("00001"), "Access permissions incorrect");
        }
        catch (Exception e)
        {
            exceptionCaught = true;
        }

        if (exceptionCaught)
        {
            fail("Exception thrown for valid id.");
        }
    }

    @Test
    void addUserTest(){

        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};

        String addedUser = "66600";

        Door testDoor = new Door("0", testUsers);

        boolean found = false;

        testDoor.addUser(addedUser);

        for (int i = 0; i < testDoor.list.size(); i++) {
            if (addedUser.equals(testDoor.list.get(i))){
                found = true;
            }
        }

        assertEquals(true, found, "Added user was not found in list");

    }

    @Test
    void removeUserTest(){

        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};

        String removedUser = "00000";

        Door testDoor = new Door("0", testUsers);

        boolean removed = false;

        testDoor.removeUser(removedUser);

        for (int i = 0; i < testDoor.list.size(); i++) {
            if (!removedUser.equals(testDoor.list.get(i))){
                removed = true;
            }
        }

        assertEquals(true, removed, "Removed user was still in list");

    }

    @Test
    void getTest(){
        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};

        Door testDoor = new Door("0", testUsers);

        assertEquals("0", testDoor.getID(), "ID retrieved does not match door ID");
    }

    @Test
    void setTest(){
        String[] testUsers = new String[]{"00000", "70879", "30429", "11293"};

        Door testDoor = new Door("0", testUsers);

        String newID = "88899";

        testDoor.setID(newID);

        assertEquals("88899", testDoor.getID(), "New ID does not match door ID");
    }

}