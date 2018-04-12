package edu.ithaca.group1;

public class Request {
    private String requestId;

    private String userId;
    private String doorId;
    private RequestStatus status;

    public Request(String requestId, String userId, String doorId, RequestStatus status)
    {
        this.requestId = requestId;
        this.userId = userId;
        this.doorId = doorId;
        this.status = status;
    }

    public Request(String requestId, String userId, String doorId)
    {
        this.requestId = requestId;
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

    public String getRequestId() { return requestId;}

    public RequestStatus getStatus() {return status;}

    public void setStatus(RequestStatus status) {this.status = status;}
}
