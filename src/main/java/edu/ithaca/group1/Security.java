package edu.ithaca.group1;

public class Security{

    private int securityState = 2;
    private boolean approved = false;

    public void viewPendingRequests()
    {
        System.out.println("List of pending requests...");
    }

    public boolean ApproveRequest()
    {
        this.approved = true;
        return approved;
    }

    public boolean DenyRequest()
    {
        this.approved = false;
        return approved;
    }

}
