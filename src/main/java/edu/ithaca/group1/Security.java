package edu.ithaca.group1;

public class Security{

    private int securityState = 2;
    private boolean approved = false;

    public Security(){}

    /**
     * Prints out a list of requests that are awaiting approval from the security rep
     */
    public void viewPendingRequests()
    {
        System.out.println("List of pending requests...");
    }

    /**
     * Approves a request from the list of pending requests
     * @return approved - status of approval should be true since request is approved
     */
    public boolean ApproveRequest()
    {
        this.approved = true;
        return approved;
    }

    /**
     * Denies a request from the list of pending requests
     * @return approved - status of approval should be false since request is denied
     */
    public boolean DenyRequest()
    {
        this.approved = false;
        return approved;
    }

}
