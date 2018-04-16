package edu.ithaca.group1;

import java.util.ArrayList;

public class Manager extends State {

    private String menuOptions = "View Approved Requests,View All Users,View All Doors,Add User,Add Door,Add Permission, Deny Permission, Return to Main Menu";
    private ArrayList<Request> approvedRequests = myDAO.getAllRequests();

    public Manager(){}

    /**
     * Starts control flow and modifies approvedRequest so that it only contains requests
     * that have been cleared by the security rep
     */
    public void run()
    {
        for (int i = 0; i < approvedRequests.size(); i++) {
            if (approvedRequests.get(i).getStatus() != RequestStatus.SECURITY_CLEARED) {
                approvedRequests.remove(i);
            }
        }

        int selection = -1;
        while(selection != 7){
            super.myConsole.listOptions(menuOptions);
            selection = super.myConsole.getInputOption(menuOptions);
            branchApp(selection);
        }
    }

    /**
     * Dictates which method will get executed based on user input
     * @param option integer gathered from user input
     */
    public void branchApp(int option)
    {
        switch(option){
            case 0:
                viewApprovedRequests(approvedRequests);
                break;
            case 1:
                viewAllUsers();
                break;
            case 2:
                viewAllDoors();
                break;
            case 3:
                addUser();
                break;
            case 4:
                addDoor();
                break;
            case 5:
                addPermission();
                break;
            case 6:
                denyPermission();
                break;
            case 7:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;
        }
    }

    /**
     * Prints out a list of requests that have been approved by the security rep
     * @param approvedRequests
     */
    public void viewApprovedRequests(ArrayList<Request> approvedRequests)
    {
        if (approvedRequests.size() > 0)
        {
            System.out.println("\nList of approved Requests:\n");
            myConsole.printRequests(approvedRequests);
        }
        else
        {
            System.out.println("No pending requests.");
        }

    }

    /**
     * Prints out a list of all the users in the system
     */
    public void viewAllUsers()
    {
        myConsole.printAllUsers(myDAO.getAllUsers());
    }

    /**
     * Prints out a list of all the doors in the system
     */
    public void viewAllDoors()
    {
        myConsole.printAllDoors(myDAO.getAllDoors());
    }

    /**
     * Adds a user by taking in their name and department
     */
    public void addUser()
    {
        System.out.println("Enter name:");
        String name = myConsole.getInputString();

        System.out.println("Enter department:");
        String department = myConsole.getInputString();

        myDAO.addUser(name, department);

        System.out.println(name + " [" + department + "] " + "was added.");
    }

    /**
     * Adds door
     */
    public void addDoor()
    {
        myDAO.addDoor();
        System.out.println("Door has been added.");
    }

    /**
     * Grants a user access to a specific door
     */
    public void addPermission()
    {
        System.out.println("Enter request ID:\n");
        String requestID = myConsole.getInputString();

        Request req = myDAO.getRequestById(requestID);

        if (req != null)
        {
            myDAO.addPermission(req.getDoorId(), req.getUserId());
            myDAO.updateRequest(req.getId(), RequestStatus.ADDED);

            System.out.println(myDAO.getUserById(req.getUserId()).getName() + " now has access to door [" + req.getDoorId() + "]");
        }
        else
        {
            System.out.println("No request with that id found.");
        }
    }

    /**
     * Grants a user access to a specific door
     */
    public void denyPermission()
    {
        System.out.println("Enter request ID:\n");
        String requestID = myConsole.getInputString();

        Request req = myDAO.getRequestById(requestID);

        if (req != null)
        {
            myDAO.updateRequest(req.getId(), RequestStatus.DENIED);

            System.out.println("Request by user " + myDAO.getUserById(req.getUserId()).getName() + " to door [" + req.getDoorId() + "] denied.");
        }
        else
        {
            System.out.println("No request with that id found.");
        }
    }
}
