package edu.ithaca.group1;
import java.io.ByteArrayInputStream;

public class Application extends State {
    private String menuOptions = "View Available Doors,Submit Application,Return to Main Menu";

    public Application(){
        super();
    }

    public void run(){
        int selection = -1;
        while(selection != 2) {
            super.myConsole.listOptions(menuOptions);
            selection = super.myConsole.getInputOption(menuOptions);
            branchApp(selection);
        }
    }

    public void branchApp(int option){
        switch(option){
            case 0:
                System.out.println("Displaying available doors...");
                myConsole.printAllDoors(myDAO.getAllDoors());
                System.out.println("\n");
                break;
            case 1:
                System.out.println("Submit a new application...");
                newApp();
                break;
            case 2:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;
        }
    }

    public void newApp(){
        System.out.println("Request access to a door... enter required information");
        System.out.println("Enter user ID:");
        String userID = myConsole.getInputString();
        System.out.println("Enter requested door ID:");
        String doorID = myConsole.getInputString();

        User user = myDAO.getUserById(userID);

        if (user != null) {
            System.out.print("Application Review:\n" +
                    "User ID: " + user.getId() + "\n" +
                    "User name: " + user.getName() + "\n" +
                    "User department: " + user.getDepartment() + "\n" +
                    "Door ID: " + doorID + "\n");

            System.out.println("Submit application? yes/no");
            String confirmation = myConsole.getInputString();
            while (!confirmation.equals("yes") && !confirmation.equals("no")) {
                System.out.println("Please enter yes/no");
                confirmation = myConsole.getInputString();
            }
            if (confirmation.equals("yes")) {
                myDAO.addRequest(doorID, userID);
                System.out.println("Your application has been submitted!");
            } else if (confirmation.equals("no")) {
                System.out.println("Application deleted");
            }
        }
        else
        {
            System.out.println("No user with id: "+ userID + " found. Canceling requests...");
        }
    }
}
