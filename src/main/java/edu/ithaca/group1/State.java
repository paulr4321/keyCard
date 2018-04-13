package edu.ithaca.group1;

public class State {

    protected Console myConsole;
    protected DataAccessObject myDAO;
    private StateStatus nextState;
    private boolean completed;


    /**
     * Constructor
     *
     **/
    public State() {

        this.nextState = StateStatus.QUIT;
        this.myConsole = new Console();
        this.myDAO = new DataAccessObject("src/main/java/edu/ithaca/group1/data/doorData.txt",
                "src/main/java/edu/ithaca/group1/data/userData.txt",
                "src/main/java/edu/ithaca/group1/data/permissionData.txt",
                "src/main/java/edu/ithaca/group1/data/requestData.txt"
        );
        this.completed = false;

    }


    /**
     * Runs the next state
     */
    public void run(){}


    /**
     *
     * @return nextState variable
     */
    public StateStatus getNextState() { return nextState; }


    /**
     * Setter for nextState
     * @param myState input state
     */
    public void setNextState(StateStatus myState) { nextState = myState; }


    /**
     * Getter for completed
     * @return boolean completed
     */
    public boolean getCompleted() { return completed; }


    /**
     * Setter for completed
     * @param isComplete
     */
    public void setCompleted(boolean isComplete) { completed = isComplete; }


}
