package edu.ithaca.group1;

import java.util.ArrayList;

public class Swipe extends State {

    private String options = "Swipe Card,Return to Main Menu";


    public Swipe(){}

    /**
     *  Run starts the control flow and overrides the run() method
     *  within State
     */
    public void run(){
        int userSelection = -1;
        while (userSelection != 1){
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
            case 0:
                boolean temp = authorizeSwipe();
                break;
            case 1:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;

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

            if (myDAO.getUserById(userID) != null) {
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
                        return authStatus;

                        //TODO - Add to Swipe history
                    }
                }
            }
        }

        if (!authStatus) {
            System.out.println("Access Denied");
            System.out.println("Returning to main menu...");
            super.setCompleted(true);
            super.setNextState(StateStatus.MAINMENU);
        }
        return authStatus;
    }
}
