package edu.ithaca.group1;

public class MainMenu extends State {
    private String menuOptions = "Security Menu,Application Menu,Manager Menu,Quit Application";

    public MainMenu(){
        super();
    }

    /**
     * Run method overwritten from state class, runs the main menu state.
     */
    public void run(){
        int selection = -1;
        super.myConsole.listOptions(menuOptions);
        selection = super.myConsole.getInputOption(menuOptions);
        branchMenu(selection);
    }

    /**
     * Branches the application menu control flow to different sub menus. One case for displaying
     * all doors, one for submitting a new application and one for returning to the main menu.
     * @param option boolean, determines which menu to display
     */
    public void branchMenu(int option){
        switch(option){
            case 0:
                System.out.println("Starting security view...");
                super.setCompleted(true);
                super.setNextState(StateStatus.SECURITY);
                break;
            case 1:
                System.out.println("Starting application view...");
                super.setCompleted(true);
                super.setNextState(StateStatus.APPLICATION);
                break;
            case 2:
                System.out.println("Starting manager view...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MANAGER);
                break;
            case 3:
                System.out.println("Quitting application...");
                super.setCompleted(true);
                super.setNextState(StateStatus.QUIT);
                break;
        }
    }
}
