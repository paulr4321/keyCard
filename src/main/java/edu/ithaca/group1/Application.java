package edu.ithaca.group1;
import java.io.ByteArrayInputStream;

public class Application extends State {
    private String menuOptions = "View Available Doors,Submit Application,Return";

    public Application(){
        super(StateStatus.APPLICATION);
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
                //TODO: call door viewing function
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
        String userID = super.myConsole.getInputString();
        System.out.println("Enter user name:");
        String userName = super.myConsole.getInputString();
        System.out.println("Enter user department:");
        String userDep = super.myConsole.getInputString();
        System.out.println("Enter requested door ID:");
        String doorID = super.myConsole.getInputString();

        System.out.print("Application Review:\n" +
                "User ID: " + userID + "\n" +
                "User name: " + userName + "\n" +
                "User department: " + userDep + "\n" +
                "Door ID: " + doorID + "\n");

        System.out.println("Submit application? yes/no");
        String confirmation = super.myConsole.getInputString();
        while(!confirmation.equals("yes") && !confirmation.equals("no")){
            System.out.println("Please enter yes/no");
            confirmation = super.myConsole.getInputString();
        }
        if(confirmation.equals("yes")){
            //TODO: format application information and send to DAO to be written
            System.out.println("Your application has been submitted!");
        }
        else if(confirmation.equals("no")){
            System.out.println("Application deleted");
        }
    }
}
