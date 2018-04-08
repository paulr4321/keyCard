package edu.ithaca.group1;

public class MainMenu {
    private Console c = new Console();
    private String menuOptions = "Security Menu,Application Menu,Manager Menu";
    private String inputOptions = "0,1,2";

    public MainMenu(){}

    public void startMainMenu(){
        int selection = -1;
        c.listOptions(menuOptions);
        selection = c.getInputOption(inputOptions);
        branchMenu(selection);
    }

    public void branchMenu(int option){
        if(option == 0){
            System.out.println("Starting security view...");
            //TODO: launch security view
        }
        if(option == 1){
            System.out.println("Starting application view...");
            //TODO: launch application view
        }
        if(option == 2){
            System.out.println("Starting manager view...");
            //TODO: launch manager view
        }
    }
}
