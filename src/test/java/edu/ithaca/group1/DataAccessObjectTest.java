package edu.ithaca.group1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessObjectTest {
    private DataAccessObject DAO;

    @BeforeEach
    void setUp() {
        DAO = new DataAccessObject("src/test/java/edu/ithaca/group1/data/testDoorData.txt", "src/test/java/edu/ithaca/group1/data/testUserData.txt", "src/test/java/edu/ithaca/group1/data/testPermissionData.txt", "src/test/java/edu/ithaca/group1/data/testRequestData.txt");

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
        //DAO.addPermission("8", "10003");
    }

    @Test
    void addDoor() {
        //DAO.addDoor();
    }

    @Test
    void addUser() {
        //DAO.addUser("Bobby Flay", "Anthropology");
    }

    @Test
    void addRequest() {
        //DAO.addRequest("1", "10000");
    }

    @Test
    void updateRequest() {
        //DAO.updateRequest("2", RequestStatus.DENIED);
    }
}