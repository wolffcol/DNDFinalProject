package DungeonSource;


public class Dungeon
{
	
	//Unimplemented
	//private Room entrance;
	//private Room exit;
	
    public static Room[][] generateDungeon(int dungeonSize){
    	Room[][] dungeon = new Room[dungeonSize][dungeonSize];
    	for(int i = 0; i < dungeon.length; i++) {
    		
    		for(int j = 0; j < dungeon[0].length; j++) {
    			dungeon[i][j] = generateRoom();
    		}
    	}
    	dungeon[0][0] = new specialItemRoom();
    	dungeon[0][dungeonSize-1] = new specialItemRoom();
    	dungeon[dungeonSize-1][0] = new specialItemRoom();
    	dungeon[dungeonSize-1][dungeonSize-1] = new specialItemRoom();
    	
    	return dungeon;
    }
    
    public static Room generateRoom() {
    	
    	int random = (int)(Math.random()*7) + 1;
    	
    	if(random <= 3) {
    		return new EncounterRoom();
    	}else if(random == 4) {
    		return new TrapRoom();
    	}else if(random == 5 || random == 6) {
    		return new ItemRoom();
    	}else {
    		return new EmptyRoom();
    	}	
    }
}