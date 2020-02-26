package DungeonSource;

import java.util.Scanner;

public class InitializeGame {
	
	static Scanner scan = new Scanner(System.in);
	private static Hero theHero;
	private static Monster theMonster;
	
	public static void BuildGame() {
		
		Dungeon dungeon = new Dungeon();
		Room[][] gameDungeon = dungeon.generateDungeon();
		dungeon.setCharacterPosition(gameDungeon, 4, 4);
		gameDungeon[4][4].triggerRoom();
		
		theHero = HeroFactory.createHero(scan);
	    theMonster = MonsterFactory.createMonster((int)(Math.random() * 3) + 1);
	 
		Battle.BattleInstance(theHero, theMonster, scan);
		
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
	
	
	
	

}
