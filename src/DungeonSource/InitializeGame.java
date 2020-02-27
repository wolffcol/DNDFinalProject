package DungeonSource;

import java.util.Scanner;

public class InitializeGame {
	
	static Scanner scan = new Scanner(System.in);
	private static Room[][] gameDungeon;
	
	public static statesHolder BuildGame() {
		
		Dungeon dungeon = new Dungeon();
		gameDungeon = dungeon.generateDungeon();
		
		int[] startRoom = new int[] {determineStartingRoom(),determineStartingRoom()};
		gameDungeon[startRoom[0]][startRoom[1]] = new EmptyRoom();
		gameDungeon[startRoom[0]][startRoom[1]].characterHasBeenHere = true;
		
		statesHolder returnState = new statesHolder(HeroFactory.createHero(scan), gameDungeon, scan, startRoom);
		
		return returnState;
		
	}
	
	public static int determineStartingRoom() {
		int x = (int)(((Math.random() * 5)-3 + 1) + 3);
		
		return x;
	}
}

class statesHolder{
    Hero theHero; 
    Room[][] dungeon;  
    Scanner scan;
    int[] currRoom;
    statesHolder(Hero theHero, Room[][] dungeon ,Scanner scan, int[] currRoom){  
        this.theHero=theHero;  
        this.dungeon = dungeon;
        this.scan = scan;  
        this.currRoom = currRoom;
    }  
} 
