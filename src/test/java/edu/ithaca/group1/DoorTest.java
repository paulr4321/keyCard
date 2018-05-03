package edu.ithaca.group1;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoorTest
{

    @Test
    void getInfo()
    {

        String department = "Health";

        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        Door testDoor = new Door("0", testUsers, department);

        for (int i = 0; i < testUsers.length; i++)
        {
            String expected = testUsers[i].toString();
            assertEquals(expected, testDoor.getInfo(testUsers[i].getId()), "User Info for user: " + testUsers[i] + "Incorrect");
        }
    }

    @Test
    void checkUserAccessExceptionTest()
    {
        String department = "Health";

        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };
        User[] invalidUsers = new User[]
                {
                        new User("#0000", "X", ""),
                        new User("00a00", "X", ""),
                        new User("1100000", "X", ""),
                        new User("aaaaa", "X", ""),
                        new User("", "X", ""),
                        new User("123456789", "X", ""),
                        new User("00 00", "X", ""),
                        new User("1234+", "X", "")
                };

        Door testDoor = new Door("0", testUsers, department);

        boolean exceptionCaught = false;

        for (int i = 0; i < invalidUsers.length; i++)
        {
            exceptionCaught = false;
            try
            {
                testDoor.checkUserAccess(invalidUsers[i].getId());
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

        String department = "Health";

        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        Door testDoor = new Door("0", testUsers, department);

        boolean exceptionCaught = false;

        try {
            for (int i = 0; i < testUsers.length; i++) {

                assertEquals(true, testDoor.checkUserAccess(testUsers[i].getId()), "Access permissions incorrect");
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

        String department = "Health";

        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        User addedUser = new User("66600", "Bryan", "");

        Door testDoor = new Door("0", testUsers, department);

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

        String department = "Health";

        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        String removedUser = "00000";

        Door testDoor = new Door("0", testUsers, department);

        boolean removed = true;

        testDoor.removeUser(removedUser);

        for (int i = 0; i < testDoor.list.size(); i++) {
            if (removedUser.equals(testDoor.list.get(i))){
                removed = false;
            }
        }

        assertEquals(true, removed, "Removed user was still in list");

    }

    @Test
    void getTest(){

        String department = "Health";

        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        Door testDoor = new Door("0", testUsers, department);

        assertEquals("0", testDoor.getID(), "ID retrieved does not match door ID");
    }

    @Test
    void setTest(){
        String department = "Health";
        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        Door testDoor = new Door("0", testUsers, department);

        String newID = "88899";

        testDoor.setID(newID);

        assertEquals("88899", testDoor.getID(), "New ID does not match door ID");
    }

    @Test void departmentTest()
    {
        String department = "Health";
        User[] testUsers = new User[]
                {
                        new User("00000", "X", ""),
                        new User("70879", "X", ""),
                        new User ("30429", "X", ""),
                        new User("11293", "X", "")
                };

        Door testDoor = new Door("0", testUsers, department);

        String newID = "88899";

        testDoor.setDepartment("Thing");
        assertEquals("Thing", testDoor.getDepartment(), "Department does not match door department");
    }


}