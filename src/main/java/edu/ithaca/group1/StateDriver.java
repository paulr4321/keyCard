package edu.ithaca.group1;

public class StateDriver {
    private State currentState;
    private boolean quit = false;

    public void start(StateStatus state)
    {
        while (!quit)
        {
            if (currentState.getCompleted())
            {
                changeState(currentState.getNextState());
            }
            currentState.run();
        }
    }

    private void changeState(StateStatus newState)
    {
        switch (newState)
        {
            case MANAGER:
                currentState = new Manager();
                break;

            case SECURITY:
                currentState = new Security();
                break;

            case QUIT:
                quit = true;
        }
    }
}
