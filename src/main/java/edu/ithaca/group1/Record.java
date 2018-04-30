package edu.ithaca.group1;

public class Record {

    private String userId;
    private String doorId;
    //private time
    private Boolean outcome;

    public Record(String userId, String doorId)
    {
        this.doorId = doorId;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getDoorId() {
        return doorId;
    }

    public void getOutcome() {
        //TODO Handle outcome
    }

}
