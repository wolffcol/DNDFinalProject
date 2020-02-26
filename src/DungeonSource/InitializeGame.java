package DungeonSource;

import java.util.Scanner;

public class InitializeGame {
	
	static Scanner scan = new Scanner(System.in);
	static Hero theHero;
	static Monster theMonster;
	
	public static void BuildGame() {
		
		theHero = HeroFactory.createHero(scan);
	    theMonster = MonsterFactory.createMonster((int)(Math.random() * 3) + 1);
	 
		Battle.BattleInstance(theHero, theMonster, scan);
		
	}
	
	public static Scanner getScanner() {
		return scan;
	}
	
	
	
	

}
