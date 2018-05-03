package edu.ithaca.group1;

public class Application extends State {
    private String menuOptions = "View Available Doors,Submit Application,Return to Main Menu";

    public Application(){
        super();
    }

    /**
     * Run method overwritten from state class, runs the application state.
     */
    public void run(){
        int selection = -1;
        while(selection != 3) {
            super.myConsole.listOptions(menuOptions);
            selection = super.myConsole.getInputOption(menuOptions);
            branchApp(selection);
        }
    }

    /**
     * Branches the application menu control flow to different sub menus. One case for displaying
     * all doors, one for submitting a new application and one for returning to the main menu.
     * @param option boolean, determines which menu to display
     */
    public void branchApp(int option){
        switch(option){
            case 1:
                System.out.println("Displaying available doors...");
                myConsole.printAllDoors(myDAO.getAllDoors());
                System.out.println("\n");
                break;
            case 2:
                System.out.println("Submit a new application...");
                newApp();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;
        }
    }

    /**
     * Guides user to submit a new application. Once the new application is created, the user
     * will have an option to submit the application or to cancel it. If the user for the request is
     * not found, the application is cancelled.
     */
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
            System.out.println("No user with id: "+ userID + " found. Canceling request...");
        }
    }
}
