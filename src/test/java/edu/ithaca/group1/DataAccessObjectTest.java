package edu.ithaca.group1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessObjectTest {
    private DataAccessObject DAO;

    @BeforeEach
    void setUp() {
        DAO = new DataAccessObject("", "", "", "");
        DAO.setDoorDataPath("src/test/java/edu/ithaca/group1/data/testDoorData.txt");
        DAO.setUserDataPath("src/test/java/edu/ithaca/group1/data/testUserData.txt");
        DAO.setPermissionDataPath("src/test/java/edu/ithaca/group1/data/testPermissionData.txt");
        DAO.setRequestDataPath("src/test/java/edu/ithaca/group1/data/testRequestData.txt");
        try {
            //reset door data file
            File doors = new File("src/test/java/edu/ithaca/group1/data/testDoorData.txt");
            FileWriter writer = new FileWriter(doors, false);
            writer.write("#13\n2%Health\n5%Health\n8%Science\n12%Music");
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
    void getAllUsers() {
        User[] testUsers = new User[]{
                new User("10000","Bryan Houst", "Mathematics"),
                new User("10001", "Susan Wheeler", "History"),
                new User("10002", "Mathew Grakowski", "Psychology")
        };
        ArrayList<User> users = DAO.getAllUsers();

        assertEquals(3, users.size(), "Incorrect number of users in user list");

        for (int i = 0; i < users.size(); i++)
        {
            assertEquals(testUsers[i].getId(), users.get(i).getId());
            assertEquals(testUsers[i].getName(), users.get(i).getName());
            assertEquals(testUsers[i].getDepartment(), users.get(i).getDepartment());
        }
    }

    @Test
    void getAllDoors() {
        ArrayList<Door> doors = DAO.getAllDoors();

        assertEquals(4, doors.size());
        assertEquals("2", doors.get(0).getID());
        assertEquals("5", doors.get(1).getID());
        assertEquals("8", doors.get(2).getID());
        assertEquals("12", doors.get(3).getID());

        ArrayList<User> permittedUsers = doors.get(0).list;
        assertEquals(2, permittedUsers.size());
        permittedUsers = doors.get(2).list;
        assertEquals(1, permittedUsers.size());

        assertEquals("10002", permittedUsers.get(0).getId());
    }

    @Test
    void getAllRequests()
    {
        ArrayList<Request> requests = DAO.getAllRequests();
        assertEquals(2, requests.size());
        assertEquals("1", requests.get(0).getDoorId());
        assertEquals("10000", requests.get(0).getUserId());
        assertEquals(RequestStatus.NEW, requests.get(0).getStatus());
        assertEquals("8", requests.get(1).getDoorId());
        assertEquals("10001", requests.get(1).getUserId());
        assertEquals(RequestStatus.SECURITY_CLEARED, requests.get(1).getStatus());
    }

    @Test
    void addPermission() {
        DAO.addPermission("8", "10001");

        ArrayList<Door> doors = DAO.getAllDoors();

        Door testDoor = doors.get(2);
        assertEquals(2, testDoor.list.size());
        assertEquals("10002", testDoor.list.get(0).getId());
    }

    @Test
    void addDoor() {

        String department = "Music";

        for (int i = 1; i < 11; i++) {
            DAO.addDoor(department);
            String id = Integer.toString(12+i);
            Door testDoor = DAO.getDoorById(id);
            assertEquals(0, testDoor.list.size());
            assertEquals(4+i, DAO.getAllDoors().size());
            assertEquals(id, testDoor.getID());
        }
    }

    @Test
    void addUser() {
        DAO.addUser("Bobby Flay", "Anthropology");
        User testUser = DAO.getUserById("10003");
        assertEquals("Bobby Flay", testUser.getName());
        assertEquals("Anthropology", testUser.getDepartment());

        for (int i = 1; i < 11; i++) {
            String name = "Test User" +Integer.toString(i);
            DAO.addUser(name, "Test");
            String id = Integer.toString(10003+i);
            testUser = DAO.getUserById(id);
            assertEquals(4+i, DAO.getAllUsers().size());
            assertEquals(id, testUser.getId());
            assertEquals(name, testUser.getName());
        }
    }

    @Test
    void addRequest() {
        for (int i = 1; i < 11; i++) {
            String doorId = Integer.toString(i);
            String userId = Integer.toString(10000 + i);
            String requestId = Integer.toString(2+i);
            DAO.addRequest(doorId, userId);
            Request testRequest = DAO.getRequestById(requestId);
            assertEquals(2+i, DAO.getAllRequests().size());
            assertEquals(requestId, testRequest.getId());
            assertEquals(doorId, testRequest.getDoorId());
            assertEquals(userId, testRequest.getUserId());
        }
    }

    @Test
    void updateRequest() {
        DAO.updateRequest("2", RequestStatus.DENIED);
        DAO.updateRequest("1", RequestStatus.SECURITY_CLEARED);
        Request request1 = DAO.getRequestById("1");
        Request request2 = DAO.getRequestById("2");
        assertEquals(RequestStatus.DENIED, request2.getStatus());
        assertEquals(RequestStatus.SECURITY_CLEARED, request1.getStatus());
        assertEquals("10000", request1.getUserId());
        assertEquals("10001", request2.getUserId());
        assertEquals("8", request2.getDoorId());
        assertEquals("1", request1.getDoorId());
    }

    @Test
    void getDoorById() {
        assertEquals("2", DAO.getDoorById("2").getID());
        assertEquals("5", DAO.getDoorById("5").getID());
        assertEquals("8", DAO.getDoorById("8").getID());
        assertEquals("12", DAO.getDoorById("12").getID());
        assertEquals(null, DAO.getDoorById("100"));
    }

    @Test
    void getUserById() {
        assertEquals("10000", DAO.getUserById("10000").getId());
        assertEquals("10001", DAO.getUserById("10001").getId());
        assertEquals("10002", DAO.getUserById("10002").getId());
        assertEquals(null, DAO.getUserById("55555"));
    }

    @Test
    void getRequestById() {
        assertEquals("1", DAO.getRequestById("1").getId());
        assertEquals("2", DAO.getRequestById("2").getId());
        assertEquals(null, DAO.getRequestById("6"));
    }

    @Test
    void addSwipeRecord()
    {

    }
}