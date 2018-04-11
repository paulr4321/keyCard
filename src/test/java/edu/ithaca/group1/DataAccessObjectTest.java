package edu.ithaca.group1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DataAccessObjectTest {
    private DataAccessObject DAO;
    private User[] testUsers;

    @BeforeEach
    void setUp() {
        DAO = new DataAccessObject("src/test/java/edu/ithaca/group1/data/testDoorData.txt", "src/test/java/edu/ithaca/group1/data/testUserData.txt", "src/test/java/edu/ithaca/group1/data/testPermissionData.txt");
        testUsers = new User[]{
                new User("00000","Bryan Houst", "Mathematics"),
                new User("54321", "Susan Wheeler", "History"),
                new User("90981", "Mathew Grakowski", "Psychology")
        };
    }

    @Test
    void getAllUsers() {
        ArrayList<User> users = DAO.getAllUsers();

        assertEquals(3, users.size(), "Incorrect number of users in user list");

        for (int i = 0; i < users.size(); i++)
        {
            assertEquals(users.get(i).getId(), testUsers[i].getId());
            assertEquals(users.get(i).getName(), testUsers[i].getName());
            assertEquals(users.get(i).getDepartment(), testUsers[i].getDepartment());
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

        assertEquals("54321", permittedUsers.get(0).getId());
    }

    @Test
    void addPermission() {
    }

    @Test
    void addDoor() {
    }

    @Test
    void addUser() {
    }
}