package edu.ithaca.group1;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    private State myState;
    private StateStatus myStateStatus;

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        myStateStatus = StateStatus.MAINMENU;
        myState = new State(myStateStatus);
    }

    @org.junit.jupiter.api.Test
    void getNextState() {
        assertEquals(myStateStatus, myState.getNextState(), "getNextState - state does not match");

    }

    @org.junit.jupiter.api.Test
    void setNextState() {
        StateStatus newStateStatus = StateStatus.SECURITY;
        myState.setNextState(newStateStatus);

        assertEquals(newStateStatus, myState.getNextState(), "setNextState - state does not match");

    }

    @org.junit.jupiter.api.Test
    void setCompleted() {
        boolean temp = false;
        myState.setCompleted(temp);

        assertEquals(temp, myState.getCompleted(), "getCompleted - boolean does not match");

    }

    @org.junit.jupiter.api.Test
    void getCompleted() {
        boolean temp = true;
        myState.setCompleted(temp);

        assertEquals(temp, myState.getCompleted(), "setCompleted - boolean does not match");


    }
}
