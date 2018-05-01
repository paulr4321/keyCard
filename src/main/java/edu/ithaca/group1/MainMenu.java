package edu.ithaca.group1;

public class MainMenu extends State {
    private String menuOptions = "Security Menu,Application Menu,Manager Menu,Swipe Menu,Quit Application";

    public MainMenu(){
        super();
    }

    public void run(){
        int selection = -1;
        super.myConsole.listOptions(menuOptions);
        selection = super.myConsole.getInputOption(menuOptions);
        branchMenu(selection);
    }

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
                System.out.println("Starting swipe view...");
                super.setCompleted(true);
                super.setNextState(StateStatus.SWIPE);
                break;
            case 4:
                System.out.println("Quitting application...");
                super.setCompleted(true);
                super.setNextState(StateStatus.QUIT);
                break;
        }
    }
}
