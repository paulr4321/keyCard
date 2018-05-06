package edu.ithaca.group1;

public class Request {
    private String id;
    private String userId;
    private String doorId;
    private RequestStatus status;

    /**
     * Request constructor
     * @param id id of the request
     * @param userId id of the user
     * @param doorId id of the door
     * @param status the status of the request
     */
    public Request(String id, String userId, String doorId, RequestStatus status)
    {
        this.id = id;
        this.userId = userId;
        this.doorId = doorId;
        this.status = status;
    }

    /**
     * Request Constructor
     * @param id id of the request
     * @param userId id of the user
     * @param doorId id of the door
     */
    public Request(String id, String userId, String doorId)
    {
        this.id = id;
        this.userId = userId;
        this.doorId = doorId;
        this.status = RequestStatus.NEW;
    }

    public String getUserId() {
        return userId;
    }

    public String getDoorId() {
        return doorId;
    }

    public String getId() { return id;}

    public RequestStatus getStatus() {return status;}

    public void setStatus(RequestStatus status) {this.status = status;}
}
