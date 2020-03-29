package dungeon;

public class InitializeGame {
	
	private static Room[][] gameDungeon;
	private static int dungeonDimension;
	
	//Potentially add a difficulty that scales the size of the dungeon 4x4 is easy, 6x6 is normal, 8x8 is hard
	public static statesHolder BuildGame() {
		
		writeTypewriter("Never did you know choosing to be an adventurer would lead you into the depths of such a hellscape.\n\n"
					  + "This place...the Object Oriented Principles Dungeons is like a nightmare.\n\n"
					  + "Your mentor, Com Tapaul, has tasked you with retrieving the sacred Artifacts of OO.\n\n"
					  + "It is no wonder he didn't come himself. You might not make it out alive.");
		
		System.out.println("\nChoose Difficulty: "+ 
						   "\n1. Easy: 4 by 4 Dungeon" +
						   "\n2. Normal: 6 by 6 Dungeon" +
						   "\n3. Hard: 8 by 8 Dungeon");
		
		int choice = GameStateManager.getInt();
		
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
		gameDungeon[startRoom[0]][startRoom[1]] = new EntranceRoom();
		gameDungeon[startRoom[0]][startRoom[1]].characterHasBeenHere = true;
		int[] exitRoom = new int[] {determineRoom(),determineRoom()};
		
		while(exitRoom[0] == startRoom [0] && exitRoom[1] == startRoom [1]) {
			exitRoom = new int[] {determineRoom(),determineRoom()};
		}
		gameDungeon[exitRoom[0]][exitRoom[1]] = new exitRoom();
		
		return new statesHolder(HeroFactory.createHero(), gameDungeon, startRoom);	
	}
	
	public static int determineRoom() {
		int x = (int)(((Math.random() * (dungeonDimension/2)+1)-(dungeonDimension/4)) + (dungeonDimension/4));
		
		return x;
	}
	
	public static int getDungeonSize() {
		return dungeonDimension;
	}
	
	public static void writeTypewriter(String str) {
		
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			GameStateManager.pauseTime(.1);
		}
		
	}
}

class statesHolder{
    Hero theHero; 
    Room[][] dungeon;  
    int[] currRoom;
    statesHolder(Hero theHero, Room[][] dungeon , int[] currRoom){  
        this.theHero=theHero;  
        this.dungeon = dungeon; 
        this.currRoom = currRoom;
    }  
} 
