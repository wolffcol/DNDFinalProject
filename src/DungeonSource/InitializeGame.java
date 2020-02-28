package DungeonSource;

import java.util.Scanner;

public class InitializeGame {
	
	static Scanner scan = new Scanner(System.in);
	private static Room[][] gameDungeon;
	private static int dungeonDimension;
	
	//Potentially add a difficulty that scales the size of the dungeon 4x4 is easy, 6x6 is normal, 8x8 is hard
	public static statesHolder BuildGame() {
		
		System.out.println("You are a dungeon crawler adventuring into the depths to discover the Artifacts of OO.");
		System.out.println("\nChoose Difficulty: "+ 
						   "\n1. Easy: 4 by 4 Dungeon" +
						   "\n2. Normal: 6 by 6 Dungeon" +
						   "\n3. Hard: 8 by 8 Dungeon");
		
		int choice = scan.nextInt();
		
		if(choice == 1) {
			dungeonDimension = 4;
		}else if(choice == 2) {
			dungeonDimension = 6;
		}else if(choice == 3) {
			dungeonDimension = 8;
		}else {
			dungeonDimension = 6;
		}
		
		System.out.println("\nYour dungeon is size " + dungeonDimension + " by " + dungeonDimension);
		
		gameDungeon = Dungeon.generateDungeon(dungeonDimension);
		
		int[] startRoom = new int[] {determineRoom(),determineRoom()};
		gameDungeon[startRoom[0]][startRoom[1]] = new entranceRoom();
		gameDungeon[startRoom[0]][startRoom[1]].characterHasBeenHere = true;
		int[] exitRoom = new int[] {determineRoom(),determineRoom()};
		
		while(exitRoom[0] == startRoom [0] && exitRoom[1] == startRoom [1]) {
			exitRoom = new int[] {determineRoom(),determineRoom()};
		}
		gameDungeon[exitRoom[0]][exitRoom[1]] = new exitRoom();
		
		return new statesHolder(HeroFactory.createHero(scan), gameDungeon, scan, startRoom);	
	}
	
	public static int determineRoom() {
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
