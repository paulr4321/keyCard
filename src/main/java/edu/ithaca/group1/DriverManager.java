package edu.ithaca.group1;

import java.util.Scanner;



public class DriverManager

{

	public DriverManager(){}
	
    /**
     * @addUser takes a door and a user as parameters
     * @addUser within Manager Class calls addUser within the Door class
     * the user given will be added to that specific door's permissions
     */
	
	public void addUser(Door door, User user){
		door.addUser(user);
		
		
	}
    /**
     * The Manager is given a list of people approved for the door.
     * @viewApprovedRequests loops through the list and prints the approved users
     */
	public void viewApprovedRequests(User[] userList){
		System.out.println("APPROVED USERS!:");
		for(int i = 0; i< userList.length; i++){
			System.out.println(userList[i]);
			System.out.println(" ");
		}
		
	}
    /**
     * denyRequest informs the user that their request has been denied 
     * User not added to the approved list.
     */
	public void denyRequest(){
		
		System.out.println("I am sorry your request has been denied.");
		
	}
	
	
	
		
		
	}

