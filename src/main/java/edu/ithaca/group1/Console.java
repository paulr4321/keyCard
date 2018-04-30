package edu.ithaca.group1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    public Console(){}

    /**
     * @param options string of options passed in by a state class
     *Formats and prints out list of options
     */
    public void listOptions(String options)
    {
        String delims = "[,]";
        String[] listOfOptions = options.split(delims);

        System.out.println("\nSelect an option:\n");

        for (int i = 0; i < listOfOptions.length; i++) {
            System.out.println(i + " : " + listOfOptions[i]);
        }
    }

    /**
     * Gets input from user. Input must be an integer. If input is not an integer, or if the input is not
     * one of the listed options, the user will be prompted until valid input is entered.
     * @param options string of options passed in by a state class
     *@return returns the option requested from the user
     */
    public int getInputOption(String options)
    {
        int input = -1;
        boolean valid = false;

        String[] listOfOptions = options.split(",");

        while(!valid){

            System.out.println("\nWhat would you like to do?\n");
            try {
                Scanner in = new Scanner(System.in);
                input = in.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                valid = false;
            }

            try {
                System.out.println("Option [" + listOfOptions[input] + "] was selected\n" );
            } catch (ArrayIndexOutOfBoundsException e){
                valid = false;
                System.out.println("Invalid input, please try again.\n");
            }

        }

        return input;

    }

    /**
     * getInputString prompts the user for field
     * names such as their first name, department, building, etc. These field names will be
     * processed as strings as opposed to getInputOption which takes in an integer from the user
     * @return getInputString returns the field name entered, which will be written out into
     * its respective location
     */
    public String getInputString()
    {
        Scanner in = new Scanner(System.in);
        boolean valid = false;
        String delims = "[a-zA-Z0-9-\\s+]*";
        String field = "";

        while(!valid){
            field = in.nextLine();
            if (field.matches(delims)){
                valid = true;
            } else {
                System.out.println("\nInvalid characters entered, please try again");
            }
        }

        return field;
    }

    /**
     * Prints a list of the requests awaiting approval from security
     * @param list ArrayList of type Requests. Will not work with other types of ArrayList
     */
    public void printRequests(ArrayList<Request> list)
    {

        //TODO: Print User Status

        for (int i = 0; i < list.size(); i++) {
            System.out.println("\nRequest ID: " + list.get(i).getId());
            System.out.println("User ID: " + list.get(i).getUserId());
            System.out.println("Door ID: " + list.get(i).getDoorId());
            System.out.println("Request Status: " + list.get(i).getStatus());
        }
    }

    /**
     * Prints a list of all doors
     * @param list ArrayList of the type Door. Only Door. Nothing else
     */
    public void printAllDoors(ArrayList<Door> list)
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Door: " + list.get(i).getID() + " [" + list.get(i).getDepartment() + "] ");
        }
    }

    /**
     * Prints list of users
     * @param list ArrayList of the type User. User.
     */
    public void printAllUsers(ArrayList<User> list)
    {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getId() + " : " + list.get(i).getName() + " [" + list.get(i).getDepartment() + "]");
        }
    }



}
