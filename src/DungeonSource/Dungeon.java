package DungeonSource;


public class Dungeon
{
	
    public Room[][] dungeon = new Room[8][8];
    
    
    public void generateDungeon(){
    	for(int i = 0; i < dungeon.length; i++) {
    		
    		for(int j = 0; j < dungeon[0].length; j++) {
    			dungeon[i][j] = generateRoom();
    		}
    	}
    }
    
    public Room generateRoom() {
    	
    	int random = (int)(Math.random()*5) + 1;
    	
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