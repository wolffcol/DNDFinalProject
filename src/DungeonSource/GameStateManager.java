package DungeonSource;

import java.util.Scanner;

public class GameStateManager {
	
	private static Room[][] gameDungeon;
	private static int[] currentRoom = new int[2];
	private static Hero theHero;
	private static Scanner scan;

	//This is where all of the main game variables need to exist to be able to control all the aspects of the games
	public static void stateSetup() {
		statesHolder state = InitializeGame.BuildGame();
		theHero = state.theHero;
		gameDungeon = state.dungeon;
		scan = state.scan;
		currentRoom = state.currRoom;
		//toString(gameDungeon);
		startGame();
	}
	
	public static void startGame() {
		theHero.nonBattleChoices(scan);
	}
	
	public static int[] getCurrentRoom() {
		return currentRoom;
	}
	
	public static Hero getHero() {
		return theHero;
	}
	
	public static void setCurrentRoom(int x, int y) {
		currentRoom[0] = x;
		currentRoom[1] = y;
		if(!gameDungeon[x][y].characterHasBeenHere) {
			gameDungeon[x][y].characterHasBeenHere = true;
			gameDungeon[x][y].triggerRoom(theHero);
		}
	}
	
	public static Scanner getScanner() {
		return scan;
	}	
	
	/*public static void toString(Room[][] dungeon) {
		
		for(int i = 0; i < dungeon.length;i++) {
			System.out.println();
			
			for(int j = 0; j < dungeon[0].length; j++) {
				System.out.print("***\r" + "* |\r" + "*-*");
			}
		}
	}*/
}
