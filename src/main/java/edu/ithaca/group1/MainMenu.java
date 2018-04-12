package edu.ithaca.group1;

public class MainMenu {
    private Console c = new Console();
    private String menuOptions = "Security Menu,Application Menu,Manager Menu";
    private String inputOptions = "0,1,2";

    public MainMenu(){}

    public int startMainMenu(){
        int selection = -1;
        c.listOptions(menuOptions);
        selection = c.getInputOption(inputOptions);
        return branchMenu(selection);
    }

    public int branchMenu(int option){
        switch(option){
            case 0:
                System.out.println("Starting security view...");
                //TODO: change to security state
                return 0;
            case 1:
                System.out.println("Starting application view...");
                //TODO: change to application state
                return 1;
            case 2:
                System.out.println("Starting manager view...");
                //TODO: change to manager state
                return 2;
            case 3:
                System.out.println("Quitting application...");
                System.exit(0);
                return 3;
            default: return -1;
        }
    }
}
