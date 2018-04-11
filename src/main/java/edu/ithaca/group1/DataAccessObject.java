package edu.ithaca.group1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class DataAccessObject {
    private String doorDataPath;
    private String userDataPath;
    private String permissionDataPath;

    public DataAccessObject(String doorDataPath, String userDataPath, String permissionDataPath){
        this.doorDataPath = doorDataPath;
        this.userDataPath = userDataPath;
        this.permissionDataPath = permissionDataPath;
    }

    private ArrayList<String> getData(String fileName)
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bfr;
        String line;

        try {
            File file=new File(fileName);

            if(file.exists()) {

                bfr = new BufferedReader(new FileReader(file));

                while ((line = bfr.readLine()) != null) {
                    list.add(line);
                }
                bfr.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @return a list of all users in currently in the system
     */
    public ArrayList<User> getAllUsers(){

        ArrayList<User> users = new ArrayList<User>();

        ArrayList<String> data = getData(userDataPath);

        for (int i = 0; i < data.size(); i++) {
            String[] fields = data.get(i).split("%");
            users.add(new User(fields[0], fields[1], fields[2]));
        }
        return users;
    }

    /**
     * @return a list of all Doors currently in the system
     */
    public ArrayList<Door> getAllDoors(){
        ArrayList<Door> doors = new ArrayList<Door>();

        ArrayList<String> doorData = getData(doorDataPath);

        ArrayList<String> permissionData = getData(permissionDataPath);

        ArrayList<User> users = getAllUsers();

        for (int i = 0; i < doorData.size(); i++) {
            String[] fields = doorData.get(i).split("%");

            String doorId = fields[0];

            ArrayList<User> doorUsers = new ArrayList<User>();

            for (int j = 0; j < permissionData.size(); j++) {
                String[] permissionFields = permissionData.get(j).split("%");
                if (permissionFields[0].equals(doorId))
                {
                    for (int k = 0; k < users.size(); k++) {
                        if (users.get(k).getId().equals(permissionFields[1]))
                        {
                            doorUsers.add(users.get(k));
                        }
                    }
                }
            }

            doors.add(new Door(doorId, doorUsers.toArray(new User[doorUsers.size()])));
        }

        return doors;
    }

    /**
     * Saves the permission to persistent data. DOES NOT handle adding the user to the door's user list.
     * However, the next time a DataAccessObject is instantiated that permission will be present
     *
     * @param userId id of the user being granted permission
     * @param doorId id of the door being granted permission to
     */
    public void addPermission(String doorId, String userId){
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter(permissionDataPath, true));

            String concat = "\n" + doorId + "%" + userId;
            output.append(concat);
            output.close();
        }
        catch (Exception e) {}
    }

    /**
     * Adds a door to the object's list. saveData must be called in order to write door to file
     * @param doorIn
     */
    public void addDoor(Door doorIn){}

    /**
     * Adds a user to the object's list. SavaData must be called in order to write door to file
     * @param user the user to be written to persistent data
     */
    public void addUser(User user){}

}
