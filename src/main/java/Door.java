public class Door {

    public boolean opened;

    public Door(String id, String[] userList){}

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
     * @param userId id of the user to get information about
     * @return boolean representing whether or not the user hass access
     * @post property opened is updated accordingly
     */
    public boolean checkUserAccess(String userId)
    {
        return false;
    }
}
