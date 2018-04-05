package edu.ithaca.group1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {

    String options;

    public Console(String options){
        this.options = options;
    }

    /**
     *Formats and prints out list of options
     */
    public void listOptions()
    {
        String delims = "[,]";
        String[] listOfOptions = options.split(delims);

        System.out.println("These are your options:\n");

        for (int i = 0; i < listOfOptions.length; i++) {
            System.out.println(i + " : " + listOfOptions[i]);
        }
    }

    /**
     * Gets input from user. Input must be an integer. If input is not an integer, or if the input is not
     * one of the listed options, the user will be prompted until valid input is entered.
     *@return returns the option requested from the user
     */
    public int getInputOption()
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
     * Prints out desired string
     * @param msg string to be printed
     */
    public void display(String msg)
    {
        System.out.println(msg);
    }

}
