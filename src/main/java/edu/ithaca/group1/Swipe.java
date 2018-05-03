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

        String doorId;
        // checks for valid door id
        while (true) {

            System.out.println("Enter Door ID");
            doorId = myConsole.getInputString();

            if (myDAO.getDoorById(doorId) != null) {
                break;
            }
            System.out.println("Invalid Door ID.. ");
        }

        ArrayList<Record> doorRecords = myDAO.getRecordsByDoor(doorId);

        for (int i = 0; i < doorRecords.size(); i++) {
            System.out.println("User ID: " + doorRecords.get(i).getUserId());
            System.out.println("Time Stamp: " + doorRecords.get(i).getTimestamp().toString());
            System.out.println("Access Granted?: " + doorRecords.get(i).getOutcome());
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

        // checks for valid user id
        while (true) {
            System.out.println("Enter User ID");
            userID = myConsole.getInputString();

            if (myDAO.getUserById(userID) != null) {
                break;
            }
            System.out.println("Invalid User ID.. ");
        }

        // checks for valid door id
        while (true) {
            System.out.println("Enter Door ID");
            doorID = myConsole.getInputString();

            if (myDAO.getDoorById(doorID) != null) {
                break;
            }
            System.out.println("Invalid Door ID.. ");
        }


        ArrayList<Door> myDoorList = super.myDAO.getAllDoors();

        for (int i = 0; i < myDoorList.size(); i++) {

            if (myDoorList.get(i).idDoor.equals(doorID)) {

                ArrayList<User> myDoorUsers = myDoorList.get(i).list;

                for (int j = 0; j < myDoorUsers.size(); j++){

                    if (myDoorUsers.get(j).getId().equals(userID)) {

                        System.out.println("Access Granted");
                        authStatus = true;

                        // create local date time of now

                        myDAO.addSwipeRecord(userID, doorID, LocalDateTime.now(), authStatus);

                        return authStatus;
                    }
                }
            }
        }

        if (!authStatus) {
            System.out.println("Access Denied");
            System.out.println("Returning to main menu...");
            myDAO.addSwipeRecord(userID, doorID, LocalDateTime.now(), authStatus);
            super.setCompleted(true);
            super.setNextState(StateStatus.MAINMENU);
        }
        return authStatus;
    }
}
