package dungeon;

public class MapBehavior {
	
	public static void fullMapReveal() {
		Room[][] gameDungeon = GameStateManager.getDungeon();
		
		for(Room[] r : gameDungeon) {
			for(Room rm : r) {
				rm.temporaryReveal = true;
			}
		}
		exploredMap();		 		 	
	}
	
	public static void resetVisionPotion() {
		Room[][] gameDungeon = GameStateManager.getDungeon();
		
		for(Room[] r : gameDungeon) {
			for(Room rm : r) {
				rm.temporaryReveal = false;
			}
		}
	}
	
	public static void exploredMap() {
		
		Room[][] gameDungeon = GameStateManager.getDungeon();
		
		int i = 0;
		
		for(i = 0; i <= ((gameDungeon.length*2)); i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.print("*");
		
		for(int j = 0; j < gameDungeon.length-1; j++) {
			
			for(i = 0; i < (gameDungeon.length-1);i++) {
				System.out.print(gameDungeon[i][j].getRoomType() + "|");
			}
			System.out.print(gameDungeon[i][j].getRoomType());
			System.out.print("*\n");
			System.out.print("*");
			
			for(i = 0; i < (gameDungeon.length);i++) {
				System.out.print("-*");
			}
			System.out.println();
			System.out.print("*");
		}
		
		for(i = 0; i < (gameDungeon.length-1);i++) {
			System.out.print(gameDungeon[i][gameDungeon.length-1].getRoomType() + "|");
		}
		System.out.print(gameDungeon[i][gameDungeon.length-1].getRoomType());
		System.out.print("*\n");
		
		for(i = 0; i <= ((gameDungeon.length*2)); i++) {
			System.out.print("*");
		}
		System.out.println();
		
	}

}
