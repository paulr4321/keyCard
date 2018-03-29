import org.junit.jupiter.api.Test;


import java.util.Scanner;



public class DriverTest

{
	@Test
	public void setupTest(String[] args) throws Exception {

		String s = null;

		User Paul = new User("12345", "Paul");
		User Vaseal = new User("54321", "Vaseal");
		User Ben = new User("12346", "Ben");
		User Fernando = new User("13456", "Ben");
		User Kevin = new User("00000", "Kevin");
		
		User Jim = new User("11111", "Jim");
		
		User[] userList = {Paul, Vaseal, Ben, Fernando, Kevin};

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
		
		door.addUser(Jim);
		
		for(int i =0; i < door.list.size();i++){
			if(door.list.get(i)==Jim){
				check = true;
			}
			else{
				check = false;
			}
		}
		assertEquals(true, check, "New ID does not match door ID");
		door.removeUser(Kevin.getId());
		
		for(int i =0; i < door.list.size();i++){
			if(door.list.get(i)==Jim){
				check = true;
			}
			else{
				check = false;
			}
		}
		assertEquals(true, check, "New ID does not match door ID");
		door.removeUser(Kevin.getId());
		
		}
		
		
		
	}