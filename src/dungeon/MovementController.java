package dungeon;

public class MovementController {
	
	static int dungeonSize = InitializeGame.getDungeonSize();
	
public static void movement() {
		
		int choice;
		
		int[] currentRoom = GameStateManager.getCurrentRoom();
		
		do {
		if(currentRoom[0] == dungeonSize-1 && currentRoom[1] == dungeonSize-1) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "East is a Wall\n"
					+ "3: West\n"
					+ "South is a Wall");
		}else if(currentRoom[0] == 0 && currentRoom[1] == 0) {
			System.out.println("Move: \n"
					+ "North is a wall\n"
					+ "2: East\n"
					+ "West is a wall\n"
					+ "4: South");
		}else if(currentRoom[1] == (dungeonSize-1) && currentRoom[0] == 0) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "West is a wall\n"
					+ "South is a wall");
		}else if(currentRoom[1] == 0 && currentRoom[0] == dungeonSize-1) {
			System.out.println("Move: \n"
					+ "North is a wall\n"
					+ "East is a wall\n"
					+ "3: West\n"
					+ "4: South");
		}else if(currentRoom[1] == 0) {
			System.out.println("Move: \n"
					+ "North is a wall\n"
					+ "2: East\n"
					+ "3: West\n"
					+ "4: South");
		}else if(currentRoom[0] == dungeonSize-1) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "East is a wall\n"
					+ "3: West\n"
					+ "4: South");
		}else if(currentRoom[0] == 0) {
			System.out.println("Move: \n"
					+ "1. North\n"
					+ "2: East\n"
					+ "West is a wall\n"
					+ "4: South");
		}else if(currentRoom[1] == dungeonSize-1) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "3: West\n"
					+ "South is a wall");
		}else if(currentRoom[0] != 0 && currentRoom[0] != dungeonSize-1 && currentRoom[1] != 0 && currentRoom[1] != dungeonSize-1){
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "3: West\n"
					+ "4: South");
		}else {	
			
		}
		System.out.println("Choose an option: ");
		choice = GameStateManager.getInt();
		
		switch(choice) {
		
			case 1:
				if((currentRoom[1]-1) < 0) {
					System.out.println("Illegal input, try again");
					choice = -1;
				}else {
				GameStateManager.setCurrentRoom(currentRoom[0], currentRoom[1]-1);
				}
				break;
			case 2:
				if((currentRoom[0] + 1) > (dungeonSize-1)) {
					System.out.println("Illegal input, try again");
					choice = -1;
				}else {
				GameStateManager.setCurrentRoom(currentRoom[0] + 1, currentRoom[1]);
				}
				break;
			case 3:
				if((currentRoom[0]-1) < 0) {
					System.out.println("Illegal input, try again");
					choice = -1;
				}else {
				GameStateManager.setCurrentRoom(currentRoom[0] - 1, currentRoom[1]);
				}
				break;
			case 4:
				if((currentRoom[1] + 1) > (dungeonSize-1)) {
					System.out.println("Illegal input, try again");
					choice = -1;
				}else {
				GameStateManager.setCurrentRoom(currentRoom[0], currentRoom[1] + 1);
				}
				break;
			default:
				choice = -1;
		}}while(choice < 0);	
			
	}

}
