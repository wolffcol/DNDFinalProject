package DungeonSource;

import java.util.Scanner;

public class InitializeGame {
	
	static Scanner scan = new Scanner(System.in);
	private static Room[][] gameDungeon;
	private static int dungeonDimension = 6;
	
	public static statesHolder BuildGame() {
		
		gameDungeon = Dungeon.generateDungeon(dungeonDimension);
		
		int[] startRoom = new int[] {determineStartingRoom(),determineStartingRoom()};
		gameDungeon[startRoom[0]][startRoom[1]] = new entranceRoom();
		gameDungeon[startRoom[0]][startRoom[1]].characterHasBeenHere = true;
		
		return new statesHolder(HeroFactory.createHero(scan), gameDungeon, scan, startRoom);	
	}
	
	public static int determineStartingRoom() {
		int x = (int)(((Math.random() * (dungeonDimension/2)+1)-(dungeonDimension/4) + 1) + (dungeonDimension/4));
		
		return x;
	}
	
	public static int getDungeonSize() {
		return dungeonDimension;
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
