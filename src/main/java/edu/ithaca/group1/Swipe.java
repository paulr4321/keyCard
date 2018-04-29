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
                authorizeSwipe();
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
        ArrayList<Door> myDoors = myDAO.getAllDoors();
        myConsole.printAllDoors(myDoors);
        System.out.println("Enter User ID");
        String userID = myConsole.getInputString();

        // TODO - ask team whether authentication should happen in DAO
        //


        return true;
    }
}
