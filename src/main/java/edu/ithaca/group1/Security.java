package edu.ithaca.group1;

import java.util.ArrayList;

public class Security extends State{

    private String menuOptions = "View Pending Requests,Approve Request,Deny Request,Quit";

    public Security(){ }

    public void run()
    {
        int selection = -1;
        while(selection != 3) {
            super.myConsole.listOptions(menuOptions);
            selection = super.myConsole.getInputOption(menuOptions);
            branchApp(selection);
        }
    }

    /**
     * branch app acts as a main menu for the Security class. Each case corresponds to a different
     * operation listed in the options from the security class
     * @param option input from user corresponding to an option
     */
    public void branchApp(int option)
    {
        switch(option){
            case 0:
                viewPendingRequests();
                break;
            case 1:
                approveRequest();
                break;
            case 2:
                denyRequest();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;
        }
    }

    /**
     * Prints out a list of requests that are awaiting approval from the security rep
     */
    public void viewPendingRequests()
    {
        ArrayList<Request> allRequests = myDAO.getAllRequests();
        System.out.println("\nUsers waiting approval:\n");

        myConsole.printRequests(allRequests);
    }

    /**
     * Approves a request from the list of pending requests
     */
    public void approveRequest()
    {
        System.out.println("Enter the request ID");
        String requestId = myConsole.getInputString();

        myDAO.updateRequest(requestId, RequestStatus.SECURITY_CLEARED);
        System.out.println("Request #" + requestId + " has been approved.\n");
    }

    /**
     * Denies a request from the list of pending requests
     */
    public void denyRequest()
    {
        System.out.println("Enter the request ID");
        String requestId = myConsole.getInputString();

        myDAO.updateRequest(requestId, RequestStatus.DENIED);
        System.out.println("Request #" + requestId + " has been denied.\n");
    }
}
