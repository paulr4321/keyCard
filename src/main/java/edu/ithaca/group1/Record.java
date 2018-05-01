package edu.ithaca.group1;
import java.time.*;

public class Record {

    private String userId;
    private String doorId;
    private LocalDateTime timestamp;
    private Boolean outcome;

    // outcome of swipe record is false by default, use setRecordStatus() to change outcome
    public Record(String userId, String doorId) {
        this.doorId = doorId;
        this.userId = userId;
        this.outcome = false;
    }

    public String getUserId() {
        return userId;
    }

    public String getDoorId() {
        return doorId;
    }

    public Boolean getOutcome() {
        return outcome;
    }

    private LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDoorId(String doorId) {
        this.doorId = doorId;
    }

    public void setOutcome(Boolean outcome) {
        this.outcome = outcome;
    }

    private void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    private void generateTimeStamp() {
        timestamp = LocalDateTime.now();
    }

    // Use this method to set the outcome of a swipe, the timestamp is generated when the record status is set
    public void setRecordStatus(Boolean status){
        this.outcome = status;
        generateTimeStamp();
    }

    // Prints the record in format: "Approved/Denied on hh:mm MM/DD/YYY"
    public String toString(){
        String status;
        int month = this.timestamp.getMonth().getValue();
        int day = this.timestamp.getDayOfMonth();
        int year = this.timestamp.getYear();
        int hour = this.timestamp.getHour();
        int min = this.timestamp.getMinute();

        if (outcome) status = "Approved";
        else status = "Denied";

        return status + " on " + hour + ":" + min + " " + month + "/" + day + "/" + year;
    }
}
