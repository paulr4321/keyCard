package prim;

public static void main(String[] args) {
    
	User user = new User();
	Doors doors = new Doors();
	boolean check;
	
	for (int i= 0; i < length; i++){
		while(door[i]==user.getDoor()){
			check = door.checkAccess();
		}
	}
	
	if(check == true){
		door.open();
	}
	else{
		door.closed();
	}
  }


