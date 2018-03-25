import org.junit.jupiter.api.Test;
import java.util.Arrays;

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

        Door testDoor = new Door("0", testUsers);

        boolean exceptionCaught = false;

        try
        {
            testDoor.checkUserAccess("#0000");
            testDoor.checkUserAccess("00a00");
            testDoor.checkUserAccess("1100000");
            testDoor.checkUserAccess("aaaaa");
            testDoor.checkUserAccess("");
            testDoor.checkUserAccess("123456789");
            testDoor.checkUserAccess("00 00");
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

            assertEquals(false, "11111", "Access permissions incorrect");
            assertEquals(false, testDoor.opened, "Door opened for invalid ID");
            assertEquals(false, "60879", "Access permissions incorrect");
            assertEquals(false, testDoor.opened, "Door opened for invalid ID");
            assertEquals(false, "30929", "Access permissions incorrect");
            assertEquals(false, testDoor.opened, "Door opened for invalid ID");
            assertEquals(false, "00001", "Access permissions incorrect");
            assertEquals(false, testDoor.opened, "Door opened for invalid ID");
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
}