package edu.ithaca.group1;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class DataAccessObject {
    private String doorDataPath;
    private String userDataPath;
    private String permissionDataPath;
    private String requestDataPath;

    public DataAccessObject(String doorDataPath, String userDataPath, String permissionDataPath, String requestDataPath){
        this.doorDataPath = doorDataPath;
        this.userDataPath = userDataPath;
        this.permissionDataPath = permissionDataPath;
        this.requestDataPath = requestDataPath;
    }

    /**
     * Helper method for getting all the data out of a file
     * @param fileName name of the file to retrieve data from
     * @return ArrayList of strings representing each line of the file
     */
    private ArrayList<String> getData(String fileName)
    {
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader bfr;
        String line;

        try {
            File file=new File(fileName);

            if(file.exists()) {

                bfr = new BufferedReader(new FileReader(file));
                bfr.readLine(); //read past id reference at top of file

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
     * Handles replacing a line in a file
     * @param filePath the file to replace a line in
     * @param toReplace the string to be replaced
     * @param replaceWith the new string
     */
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

    /**
     * Handles incrementing the reference id at the top of a file
     * @param filePath the filepath of the file to use
     */
    private void incrementId(String filePath)
    {
        try {
            BufferedReader bfr;
            File file = new File(filePath);

            if (file.exists()) {
                bfr = new BufferedReader(new FileReader(file));
                String origId = bfr.readLine();
                String newId = Integer.toString(Integer.parseInt(origId.substring(1))+1);
                bfr.close();
                replaceLine(filePath, origId, "#"+newId);
            }
        }
        catch (Exception e){}
    }

    /**
     * Handles creating a properly formatted string for writing to files
     * @param id id of entry
     * @param fields an array of all the fields of the entry
     * @return the formatted string
     */
    private String createFileEntry(String id, String[] fields)
    {
        String entry = id;
        for (int i = 0; i < fields.length; i++) {
            entry += "%" + fields[i];
        }
        return entry;
    }

    /**
     * Adds an entry to the bottom of a file
     * @param filePath filepath of the file to write to
     * @param fields fields of the entry to be added
     */
    private void appendToFile(String filePath, String[] fields)
    {
        try {
            BufferedReader bfr;
            String nextId;
            File file = new File(filePath);

            if(file.exists()) {

                bfr = new BufferedReader(new FileReader(file));
                nextId = bfr.readLine().substring(1);
                bfr.close();
                incrementId(filePath);

                BufferedWriter output = new BufferedWriter(new FileWriter(filePath, true));

                String entry = createFileEntry(nextId, fields);

                output.append(entry);
                output.close();
            }
        }
        catch (Exception e) {}
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

            String department = fields[1];

            ArrayList<User> doorUsers = new ArrayList<User>();

            for (int j = 0; j < permissionData.size(); j++) {
                String[] permissionFields = permissionData.get(j).split("%");
                if (permissionFields[1].equals(doorId))
                {
                    for (int k = 0; k < users.size(); k++) {
                        if (users.get(k).getId().equals(permissionFields[2]))
                        {
                            doorUsers.add(users.get(k));
                        }
                    }
                }
            }

            doors.add(new Door(doorId, doorUsers.toArray(new User[doorUsers.size()]), department));
        }

        return doors;
    }

    /**
     * Gets all the requests in the system
     * @return an ArrayList of all the pending request objects
     */
    public ArrayList<Request> getAllRequests()
    {
        ArrayList<Request> requests = new ArrayList<Request>();

        ArrayList<String> data = getData(requestDataPath);

        for (int i = 0; i < data.size(); i++) {
            String[] fields = data.get(i).split("%");
            requests.add(new Request(fields[0], fields[1], fields[2], RequestStatus.valueOf(fields[3])));
        }
        return requests;
    }

    /**
     * Saves the permission to persistent data. DOES NOT handle adding the user to the door's user list.
     * However, the next time a DataAccessObject is instantiated that permission will be present
     *
     * @param userId id of the user being granted permission
     * @param doorId id of the door being granted permission to
     */
    public void addPermission(String doorId, String userId){
        appendToFile(permissionDataPath, new String[]{doorId, userId});
    }

    /**
     * Adds a door to the database
     */
    public void addDoor(String department)
    {
        appendToFile(doorDataPath, new String[]{ department });
    }

    /**
     * Adds a new user to the database
     * @param name name of the new user
     * @param department department of the new user
     */
    public void addUser(String name, String department)
    {
        appendToFile(userDataPath, new String[]{name, department});
    }
    /**
     * Adds a new user to the database
     * @param name name of the new user
     * @param department department of the new user
     */
    public void deleteUser(User user)
    {
    	 String[] fields = new String[]{user.getId()};
         replaceLine(userDataPath, createFileEntry(user.getId(), fields), "" );
         replaceLine(permissionDataPath, createFileEntry(user.getId(), fields), "" );
     }

    /**
     * Adds a new request to the database
     * @param doorId id of the door the user is requesting permission to
     * @param userId id of the user requesting permission
     */
    public void addRequest(String doorId, String userId)
    {
        appendToFile(requestDataPath, new String[]{userId, doorId, RequestStatus.NEW.toString()});
    }

    /**
     * Handles updating the status of a request in the database
     * @param requestId the id of the request to be updated
     * @param newStatus the new status of the request
     */
    public void updateRequest(String requestId, RequestStatus newStatus)
    {
        ArrayList<Request> requests = getAllRequests();

        for (int i = 0; i < requests.size(); i++) {
            Request req = requests.get(i);
            if (req.getId().equals(requestId))
            {
                String[] fields = new String[]{req.getUserId(), req.getDoorId(), req.getStatus().toString()};
                String[] newFields = new String[]{req.getUserId(), req.getDoorId(), newStatus.toString()};
                replaceLine(requestDataPath, createFileEntry(req.getId(), fields), createFileEntry(req.getId(), newFields));
            }
        }
    }

    //NOTE: All of these getById methods could be more effecient with a bin find, as the data is sorted by nature

    /**
     * Gets a specific door using its id
     * @param id id of the requested door
     * @return the requested door, or null if not found
     */
    public Door getDoorById(String id)
    {
        ArrayList<Door> doors= getAllDoors();
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i).getID().equals(id))
            {
                return doors.get(i);
            }
        }
        return null;
    }

    /**
     * Gets a specific user using its id
     * @param id id of the requested user
     * @return the requested user, or null if not found
     */
    public User getUserById(String id)
    {
        ArrayList<User> users = getAllUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId().equals(id))
            {
                return users.get(i);
            }
        }
        return null;
    }

    /**
     * Gets a specific request using its id
     * @param id id of the requested request
     * @return the requested request, or null if not found
     */
    public Request getRequestById(String id)
    {
        ArrayList<Request> requests = getAllRequests();
        for (int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getId().equals(id))
            {
                return requests.get(i);
            }
        }
        return null;
    }
}
