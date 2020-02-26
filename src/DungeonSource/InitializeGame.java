package DungeonSource;

import java.util.Scanner;

public class InitializeGame {
	
	static Scanner scan = new Scanner(System.in);
	private static Hero theHero;
	private static Monster theMonster;
	
	public static void BuildGame() {
		
		Dungeon dungeon = new Dungeon();
		Room[][] gameDungeon = dungeon.generateDungeon();
		
		theHero = HeroFactory.createHero(scan);
		
		int[] startRoom = new int[] {determineStartingRoom(),determineStartingRoom()};
		gameDungeon[startRoom[0]][startRoom[1]] = new EmptyRoom();
		gameDungeon[startRoom[0]][startRoom[1]].characterHasBeenHere = true;
	 	
	}
	
	public static Scanner getScanner() {
		return scan;
	}
	
	public static Hero getHero() {
		return theHero;
	}
	
	public static Monster getMonster() {
		return theMonster;
	}
	
	public static int determineStartingRoom() {
		int x = (int)(((Math.random() * 6)-4) + 1);
		
		return x;
	}

}
