import java.util.ArrayList;
import java.util.Arrays;

public class Door {

    public boolean opened;
    public ArrayList<String> list = new ArrayList<String>();
    public String idDoor;

    public Door(String id, String[] userList)
    {
        list.addAll(Arrays.asList(userList));
        idDoor = id;
    }

    /**
     * Prints the list of users who have been granted access specific to this door
     */
    public void getUserList()
    {
        list.toString();
    }

    /**
     * Adds a new user to the userList
     * @param userID id of the user that will be added
     * @post ArrayList will increase in size by 1, containing the new user
     */
    public void addUser(String userID)
    {
        list.add(userID);
    }

    /**
     * Removes existing user from the userList
     * @param userID id of the user that will be removed
     * @post ArrayList will decrease in size by 1, removing the specified user from the list
     */
    public void removeUser(String userID)
    {
        list.remove(userID);
    }

    /**
     * Gets the idDoor
     * @return idDoor
     */
    public String getID()
    {
        return idDoor;
    }

    /**
     *
     * @param newID chosen ID to be replace the existing door ID
     * @return idDoor - should be different from the previous door ID
     */
    public String setID(String newID)
    {
        idDoor = newID;
        return idDoor;
    }

    /**
     * @param userId the id of user to get information about
     * @return information of user
     */
    public String getInfo(String userId)
    {
        return "";
    }

    /**
     * Check to see if a specified user has access, if so grant it otherwise deny access
     *
     * @throws Exception if id is more/less than 5 characters, or contains anything besides numbers
     * @param userID id of the user to get information about
     * @return boolean representing whether or not the user hass access
     * @post property opened is updated accordingly
     */
    public boolean checkUserAccess(String userID) throws Exception
    {
        if (!userID.matches("[0-9]+") && userID.length() != 5){
            throw new Exception("Invalid userId");
        }

        for (int i = 0; i < list.size(); i++) {
            if (userID.equals(list.get(i))){
                this.opened = true;
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the opened property of door to true
     */
    private void grantAccess()
    {
        opened = true;
    }

    /**
     * Sets the opened property of door to false
     */
    private void denyAccess()
    {
        opened = false;
    }





}
