package edu.ithaca.group1;

import javax.xml.crypto.Data;
import com.google.gson.*;

public class DataAccessObject {
    private String doorDataPath;
    private String userDataPath;
    private String permissionDataPath;
    private User[] users;
    private Door[] doors;

    public DataAccessObject(String doorDataPath, String userDataPath, String permissionDataPath){
        this.doorDataPath = doorDataPath;
        this.userDataPath = userDataPath;
        this.permissionDataPath = permissionDataPath;
    }

    /**
     * @return a list of all users in currenty in the system
     */
    public User[] getAllUsers(){
        return new User[]{};
    }

    /**
     * @return a list of all Doors currently in the system
     */
    public Door[] getAllDoors(){
        return new Door[]{};
    }

    /**
     * Saves the permission to persistent data. DOES NOT handle adding the user to the door's user list.
     * However, the next time a DataAccessObject is instantiated that permission will be present
     *
     * @param userId id of the user being granted permission
     * @param doorId id of the door being granted permission to
     */
    public void addPermission(String userId, String doorId){}

    /**
     * Adds a door to the object's list. saveData must be called in order to write door to file
     * @param doorIn
     * @return the newly updated door list
     */
    public Door[] addDoor(Door doorIn){
        return doors;
    }

    /**
     * Adds a user to the object's list. SavaData must be called in order to write door to file
     * @return
     */
    public User[] addUser(){
        return users;
    }

    /**
     * Writes this objects current list of users and doors into persistent data storage
     */
    public void saveData(){}

    /**
     * Takes a list of doors and writes them to persistent storage. This list will replace
     * previous data
     * @param doors the doors to be written to persistent data
     */
    public void saveDoors(Door[] doors){}

    /**
     * Takes a list of userss and writes them to persistent storage. This list will replace
     * previous data
     * @param  users the users to be written to persistent data
     */
    public void saveUsers(User[] users){}
}
