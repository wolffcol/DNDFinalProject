package dungeon;

public class VisionPotion extends Items{

	private String name = "Vision Potion";
	
	public String getName() {
		return name;
	}
	
	public void useItem(Hero theHero, DungeonCharacter theMonster) {
		Room[][] gameDungeon = GameStateManager.getDungeon();
		int[] currentRoom = GameStateManager.getCurrentRoom();
		try{gameDungeon[currentRoom[0]][currentRoom[1]-1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]+1][currentRoom[1]-1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]+1][currentRoom[1]].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]+1][currentRoom[1]+1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]][currentRoom[1]+1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]-1][currentRoom[1]+1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]-1][currentRoom[1]].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]-1][currentRoom[1]-1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		
		MapBehavior.exploredMap();
	}
}
