package DungeonSource;

import java.util.Scanner;

public class GameStateManager {
	
	private static Room[][] gameDungeon;
	private static int[] currentRoom = new int[2];
	private static Hero theHero;
	private static Scanner scan;

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
		System.out.println("I am currently in Room: " + x + " , " + y);
		if(!gameDungeon[x][y].characterHasBeenHere) {
			gameDungeon[x][y].characterHasBeenHere = true;
			gameDungeon[x][y].triggerRoom(theHero);
		}else {
			System.out.println("This room feels familiar");
		}
	}
	
	public static Scanner getScanner() {
		return scan;
	}

	public static void winGame() {
		System.out.println("You have conquered the four pillars of OO and have become a code dungeon wizard.");
		
	}
	
	public static void visionPotionReveal() {
		
		System.out.println("North Room: " + gameDungeon[currentRoom[0]][currentRoom[1]-1].getClass().toString().substring(20));
		System.out.println("Northeast Room: " + gameDungeon[currentRoom[0]+1][currentRoom[1]-1].getClass().toString().substring(20));
		System.out.println("East Room: " + gameDungeon[currentRoom[0]+1][currentRoom[1]].getClass().toString().substring(20));
		System.out.println("Southeast Room: " + gameDungeon[currentRoom[0]+1][currentRoom[1]+1].getClass().toString().substring(20));
		System.out.println("South Room: " + gameDungeon[currentRoom[0]][currentRoom[1]+1].getClass().toString().substring(20));
		System.out.println("Southwest Room: " + gameDungeon[currentRoom[0]-1][currentRoom[1]+1].getClass().toString().substring(20));
		System.out.println("West Room: " + gameDungeon[currentRoom[0]-1][currentRoom[1]].getClass().toString().substring(20));
		System.out.println("Northwest Room: " + gameDungeon[currentRoom[0]-1][currentRoom[1]-1].getClass().toString().substring(20));
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
