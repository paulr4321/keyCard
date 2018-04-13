package edu.ithaca.group1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

class SecurityTest {
    private DataAccessObject DAO;

    @BeforeEach
    void setUp() {
        DAO = new DataAccessObject("src/test/java/edu/ithaca/group1/data/testDoorData.txt", "src/test/java/edu/ithaca/group1/data/testUserData.txt", "src/test/java/edu/ithaca/group1/data/testPermissionData.txt", "src/test/java/edu/ithaca/group1/data/testRequestData.txt");

        try {
            //reset door data file
            File doors = new File("src/test/java/edu/ithaca/group1/data/testDoorData.txt");
            FileWriter writer = new FileWriter(doors, false);
            writer.write("#13\n2\n5\n8\n12");
            writer.close();

            //reset user data file
            File users = new File("src/test/java/edu/ithaca/group1/data/testUserData.txt");
            writer = new FileWriter(users, false);
            writer.write("#10003\n" +
                    "10000%Bryan Houst%Mathematics\n" +
                    "10001%Susan Wheeler%History\n" +
                    "10002%Mathew Grakowski%Psychology");
            writer.close();

            //reset permission data file
            File permissions = new File("src/test/java/edu/ithaca/group1/data/testPermissionData.txt");
            writer = new FileWriter(permissions, false);
            writer.write("#6\n" +
                    "1%2%10000\n" +
                    "2%2%10002\n" +
                    "3%5%10001\n" +
                    "4%8%10002\n" +
                    "5%5%10000");
            writer.close();

            //reset request data file
            File requests = new File("src/test/java/edu/ithaca/group1/data/testRequestData.txt");
            writer = new FileWriter(requests, false);
            writer.write("#3\n" +
                    "1%10000%1%NEW\n" +
                    "2%10001%8%SECURITY_CLEARED");
            writer.close();
        }
        catch (Exception e){}
    }

    @Test
    void viewPendingRequests() {

        Console c = new Console();
        DataAccessObject myDao = new DataAccessObject("src/test/java/edu/ithaca/group1/data/testDoorData.txt", "src/test/java/edu/ithaca/group1/data/testUserData.txt", "src/test/java/edu/ithaca/group1/data/testPermissionData.txt", "src/test/java/edu/ithaca/group1/data/testRequestData.txt");

        c.printRequests(myDao.getAllRequests());

        myDao.updateRequest("1", RequestStatus.DENIED);

    }

    @Test
    void approveRequest() {

        Console c = new Console();
        DataAccessObject myDao = new DataAccessObject("src/test/java/edu/ithaca/group1/data/testDoorData.txt", "src/test/java/edu/ithaca/group1/data/testUserData.txt", "src/test/java/edu/ithaca/group1/data/testPermissionData.txt", "src/test/java/edu/ithaca/group1/data/testRequestData.txt");

        c.printRequests(myDao.getAllRequests());
        myDao.updateRequest("1", RequestStatus.SECURITY_CLEARED);
        c.printRequests(myDao.getAllRequests());

    }

    @Test
    void denyRequest() {
        Console c = new Console();
        DataAccessObject myDao = new DataAccessObject("src/test/java/edu/ithaca/group1/data/testDoorData.txt", "src/test/java/edu/ithaca/group1/data/testUserData.txt", "src/test/java/edu/ithaca/group1/data/testPermissionData.txt", "src/test/java/edu/ithaca/group1/data/testRequestData.txt");


        System.out.println("Before");
        c.printRequests(myDao.getAllRequests());

        System.out.println("After");
        myDao.updateRequest("1", RequestStatus.DENIED);
        c.printRequests(myDao.getAllRequests());
    }
}