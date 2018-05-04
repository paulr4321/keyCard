package edu.ithaca.group1;

import java.time.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @Test
    void getUserIdTest() {
        LocalDateTime timestamp = LocalDateTime.now();
        Record rec = new Record("10101", "22", timestamp, false);
        String id = rec.getUserId();
        assertEquals("10101", id);
    }

    @Test
    void getDoorIdTest() {
        LocalDateTime timestamp = LocalDateTime.now();
        Record rec = new Record("10101", "22", timestamp, false);
        String id = rec.getDoorId();
        assertEquals("22", id);
    }

    @Test
    void getOutcomeTest() {
        LocalDateTime timestamp = LocalDateTime.now();
        Record rec = new Record("10101", "22", timestamp, false);
        Boolean result = rec.getOutcome();
        assertEquals(false, result);
    }

    @Test
    void getTimestampTest() {
        LocalDateTime timestamp = LocalDateTime.of(2012, 6, 30, 12, 00);
        Record rec = new Record("10101", "22", timestamp, false);
        int compare = timestamp.compareTo(rec.getTimestamp());
        assertEquals(0, compare);
    }

    @Test
    void setUserIdTest() {
        LocalDateTime timestamp = LocalDateTime.now();
        Record rec = new Record("10101", "22", timestamp, false);
        String IdToSet = "11111";
        rec.setUserId(IdToSet);
        assertEquals(IdToSet, rec.getUserId());
    }

    @Test
    void setDoorIdTest() {
        LocalDateTime timestamp = LocalDateTime.now();
        Record rec = new Record("10101", "22", timestamp, false);
        String IdToSet = "33";
        rec.setDoorId(IdToSet);
        assertEquals(IdToSet, rec.getDoorId());
    }

    @Test
    void setOutcomeTest() {
        LocalDateTime timestamp = LocalDateTime.now();
        Record rec = new Record("10101", "22", timestamp, false);
        rec.setOutcome(true);
        assertEquals(true, rec.getOutcome());
    }

    @Test
    void setTimestampTest() {
        LocalDateTime timestamp1 = LocalDateTime.now();
        LocalDateTime timestamp2 = LocalDateTime.of(2012, 6, 30, 12, 00);
        Record rec = new Record("10101", "22", timestamp1, false);
        rec.setTimestamp(timestamp2);
        int compare = timestamp2.compareTo(rec.getTimestamp());
        assertEquals(0, compare);
    }
}