package edu.ithaca.group1;

public class Request {
    private String userId;
    private String doorId;

    public Request(String userId, String doorId)
    {
        this.userId = userId;
        this.doorId = doorId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDoorId() {
        return doorId;
    }
}
