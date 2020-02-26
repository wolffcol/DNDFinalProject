package DungeonSource;

public class GameStateManager {
	
	
	private int[] currentRoom = new int[2];
	private Hero theHero;

	//This is where all of the main game variables need to exist to be able to control all the aspects of the games
	//Interactions between Hero and Monster
	
	public int[] getCurrentRoom() {
		return currentRoom;
	}
	
	public Hero getHero() {
		return theHero;
	}
	
}
