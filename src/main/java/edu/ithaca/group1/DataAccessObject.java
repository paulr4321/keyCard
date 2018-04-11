package edu.ithaca.group1;

import java.io.*;
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
                bfr.readLine();

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

    private void replaceLine(String filePath, String toReplace, String replaceWith) {
        try {
            BufferedReader file = new BufferedReader(new FileReader(filePath));
            String line;
            StringBuffer inputBuffer = new StringBuffer();

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            String inputStr = inputBuffer.toString();

            file.close();

            inputStr = inputStr.replace(toReplace, replaceWith);

            FileOutputStream fileOut = new FileOutputStream(filePath);
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }

    private void incrementId(String filePath, String id)
    {
        replaceLine(filePath, id+"\n", Integer.toString(Integer.parseInt(id)+1)+"\n");
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
            BufferedReader bfr;
            String nextId;
            File file = new File(permissionDataPath);

            if(file.exists()) {

                bfr = new BufferedReader(new FileReader(file));
                nextId = bfr.readLine();
                bfr.close();
                incrementId(permissionDataPath, nextId);

                BufferedWriter output = new BufferedWriter(new FileWriter(permissionDataPath, true));

                String concat = nextId + doorId + "%" + userId;
                output.append(concat);
                output.close();
            }
        }
        catch (Exception e) {}
    }

    /**
     * Adds a door to the object's list. saveData must be called in order to write door to file
     */
    public void addDoor(){

        try {
            BufferedReader bfr;
            String nextId;
            File file = new File(doorDataPath);

            if(file.exists()) {

                bfr = new BufferedReader(new FileReader(file));
                nextId = bfr.readLine();
                bfr.close();
                incrementId(doorDataPath, nextId);
                BufferedWriter output = new BufferedWriter(new FileWriter(doorDataPath, true));

                String concat = nextId; //add other fields from param here
                output.append(concat);
                output.close();
            }
        }
        catch (Exception e) {}
    }

    /**
     * Add's a new user to the database
     * @param name name of the new user
     * @param department department of the new user
     */
    public void addUser(String name, String department){
        try {
            BufferedReader bfr;
            String nextId;
            File file = new File(userDataPath);

            if (file.exists())
            {

                bfr = new BufferedReader(new FileReader(file));
                nextId = bfr.readLine();
                bfr.close();
                incrementId(userDataPath, nextId);

                BufferedWriter output = new BufferedWriter(new FileWriter(userDataPath, true));

                String concat = nextId + "%" + name + "%" + department;
                output.append(concat);
                output.close();
            }
        }
        catch (Exception e) {}
    }
}
