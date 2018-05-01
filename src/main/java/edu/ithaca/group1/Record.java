package edu.ithaca.group1;
import java.time.*;

public class Record {

    private String userId;
    private String doorId;
    private LocalDateTime timestamp;
    private Boolean outcome;

    public Record(String userId, String doorId, LocalDateTime timestamp, Boolean outcome) {
        this.doorId = doorId;
        this.userId = userId;
        this.timestamp = timestamp;
        this.outcome = outcome;
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
}
