package edu.ithaca.group1;

public class MainMenu extends State {
    private String menuOptions = "Security Menu,Application Menu,Manager Menu";
    private String inputOptions = "0,1,2";

    public MainMenu(){
        super(StateStatus.MAINMENU);
    }

    public void run(){
        int selection = -1;
        super.myConsole.listOptions(menuOptions);
        selection = super.myConsole.getInputOption(inputOptions);
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
                System.out.println("Quitting application...");
                System.exit(0);
                break;
        }
    }
}
