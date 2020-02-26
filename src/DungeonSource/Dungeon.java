package DungeonSource;


public class Dungeon
{
	
    public Room[][] generateDungeon(){
    	Room[][] dungeon = new Room[8][8];
    	for(int i = 0; i < dungeon.length; i++) {
    		
    		for(int j = 0; j < dungeon[0].length; j++) {
    			dungeon[i][j] = generateRoom();
    		}
    	}
    	return dungeon;
    }
    
    public Room generateRoom() {
    	
    	int random = (int)(Math.random()*6) + 1;
    	
    	if(random == 1 || random == 2) {
    		return new EncounterRoom();
    	}else if(random == 3) {
    		return new TrapRoom();
    	}else if(random == 4) {
    		return new ItemRoom();
    	}else {
    		return new EmptyRoom();
    	}	
    }
}