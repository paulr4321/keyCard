package edu.ithaca.group1;
import java.time.*;

public class Record {

    private String userId;
    private String doorId;
    private LocalDateTime timestamp;
    private Boolean outcome;

    /**
     * Constructor
     */
    public Record(String userId, String doorId, LocalDateTime timestamp, Boolean outcome) {
        this.doorId = doorId;
        this.userId = userId;
        this.timestamp = timestamp;
        this.outcome = outcome;
    }

    /**
     * Gets the user ID
     * @return user ID string
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the door ID
     * @return door ID String
     */
    public String getDoorId() {
        return doorId;
    }

    /**
     * Gets the outcome of a record
     * @return outcome boolean
     */
    public Boolean getOutcome() {
        return outcome;
    }

    /**
     * Gets the timestamp LocalDateTime object
     * @return timestamp LocalDateTime
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the user ID
     * @param userId new user ID string
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Sets the door ID
     * @param doorId new door ID string
     */
    public void setDoorId(String doorId) {
        this.doorId = doorId;
    }

    /**
     * Sets the outcome
     * @param outcome new outcome boolean
     */
    public void setOutcome(Boolean outcome) {
        this.outcome = outcome;
    }

    /**
     * Sets a new LocalDateTime timestamp
     * @param timestamp new timestamp LocalDateTime
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
