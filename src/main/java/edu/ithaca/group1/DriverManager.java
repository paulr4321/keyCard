package edu.ithaca.group1;
import org.junit.jupiter.api.Test;
import java.util.Scanner;



public class DriverManager

{

	public static void main(String[] args)throws Exception {
		
		String s = null;

		User[] userList = {new User("00000", "Brenda", ""), new User("11111", "Kevin", "")};

		Door door = new Door("", userList);

		boolean check;

		try{
		    Scanner reader = new Scanner(System.in);  // Reading from System.in
		    System.out.println("Enter 5 numbers: ");
		    s = reader.next();
		}
		
		catch (NumberFormatException a){
		    System.out.print("Problem");
		}
		
		check = door.checkUserAccess(s);
		
		
		if(check == true){
			System.out.print("Access Granted");
		}
		else{
			System.out.print("Access Denied");
		}
		
//		Scanner reader2 = new Scanner(System.in);  // Reading from System.in
//	    System.out.println("Would you like to Add someone from the list? (yes) or (no)");
//	    s = reader2.next();
//	    if(s=="yes"){
//	    	Scanner reader3 = new Scanner(System.in);  // Reading from System.in
//		    System.out.println("What is his or her name?");
//		    s = reader3.next();
//		    User newUser = new User("11110", s);
//		    door.addUser(newUser);
//
//	    }
//
//		Scanner reader4 = new Scanner(System.in);  // Reading from System.in
//	    System.out.println("Would you like to Remove someone from the list? (yes) or (no)");
//	    s = reader2.next();
//	    if(reader2.next()=="yes"){
//	    	try{
//	    		Scanner reader3 = new Scanner(System.in);  // Reading from System.in
//			    System.out.println("What is his or her ID?");
//			    s = reader4.next();
//			    door.removeUser(s);
//			}
//
//			catch (NumberFormatException a){
//			    System.out.print("Problem");
//			}
//
//
//
//	    }
	    
		
		
	}

}