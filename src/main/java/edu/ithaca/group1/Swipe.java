package edu.ithaca.group1;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Swipe extends State {

    private String options = "Swipe Card,Door History,Return to Main Menu";


    public Swipe(){}

    /**
     *  Run starts the control flow and overrides the run() method
     *  within State
     */
    public void run(){
        int userSelection = -1;
        while (userSelection != 3){
            super.myConsole.listOptions(options);
            userSelection = super.myConsole.getInputOption(options);
            branchApp(userSelection);

        }
    }

    /**
     * Method that handles branching the application based on
     * user input
     * @param option input from user
     */
    public void branchApp(int option){

        switch(option){
            case 1:
                boolean temp = authorizeSwipe();
                break;
            case 2:
                System.out.println("Opening Door History...");
                doorHistory();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;

        }
    }

    /**
     * prints out the door history of a specific door specified by the user
     */
    public void doorHistory(){

        System.out.println("Enter the door ID:");
        String doorId = myConsole.getInputString();
        Door door = myDAO.getDoorById(doorId);

        if (door != null)
        {
            ArrayList<Record> records = myDAO.getRecordsByDoor(doorId);
            if (records.size() > 0) {
                System.out.println("\nDoor history for door " + door.getID() + ":");
                myConsole.printSwipeRecords(records);
            } else {
                System.out.println("No Records for this door.");
            }
        }
        else
        {
            System.out.println("No door found with ID: "+doorId);
        }
    }

    /**
     *
     * @return a boolean value based on whether the swipe was accepted
     * or denied
     */
    public boolean authorizeSwipe(){

        boolean authStatus = false;
        ArrayList<Door> myDoors = myDAO.getAllDoors();
        myConsole.printAllDoors(myDoors);
        String userID;
        String doorID;
        User user;
        Door door;

        // checks for valid user id
        while (true) {
            System.out.println("Enter User ID");
            userID = myConsole.getInputString();
            user = myDAO.getUserById(userID);
            if (user != null) {
                break;
            }
            System.out.println("Invalid User ID.. ");
        }

        // checks for valid door id
        while (true) {
            System.out.println("Enter Door ID");
            doorID = myConsole.getInputString();
            door = myDAO.getDoorById(doorID);
            if (door != null) {
                break;
            }
            System.out.println("Invalid Door ID.. ");
        }


        try
        {
            authStatus = door.checkUserAccess(user.getId());
            myDAO.addSwipeRecord(userID, doorID, LocalDateTime.now(), authStatus);
            System.out.println(authStatus ? "ACCESS GRANTED" : "ACCESS DENIED");
        }
        catch (Exception e){}

        return authStatus;
    }
}
