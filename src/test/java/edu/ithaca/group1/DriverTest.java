package edu.ithaca.group1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;



public class DriverTest

{
	User Paul;
	User Vaseal;
	User Ben;
	User Fernando;
	User Kevin;
	User Jim;
	User Rob;
	DriverManager manager;
	Door door;
	User[] userList;
	ArrayList<String> list = new ArrayList<String>();
	
	@BeforeEach
	public void setupTest() throws Exception {

		String s = null;

		Paul = new User("12345", "Paul", "");
		Vaseal = new User("54321", "Vaseal", "");
		Ben = new User("12346", "Ben", "");
		Fernando = new User("13456", "Fernando", "");
		Kevin = new User("00000", "Kevin", "");
		
		Jim = new User("11110", "Jim", "");
		Rob = new User("11112", "Rob", "");
		
		userList = new User[]{Paul, Vaseal, Ben, Fernando, Kevin};
		door = new Door("", userList);

		manager = new DriverManager();
		
	}
	@Test
	public void addTest() throws Exception{
		manager.addUser(door, Jim);
		boolean check = door.checkUserAccess("Jim");
		assertEquals(true, check, "Access permissions incorrect");
		
		
		
	}

	@Test
	public void viewApprovedList(){
		manager.viewApprovedRequests(userList);
	}
		
	@Test
	public void deny(){
		manager.denyRequest();
		
	}
		
		
		
}