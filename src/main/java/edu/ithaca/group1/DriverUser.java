
package edu.ithaca.group1;
//import org.junit.jupiter.api.Test;
import java.util.Scanner;



public class DriverUser

{

	public static void main(String[] args) throws Exception {
		
		String s = null;

		User[] userList = {};

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
		
		
	}

}