package DungeonSource;

import java.util.Scanner;

//Move the method from the dungeon class to exist here
public class Battle {
	
	public static void BattleInstance(Hero theHero, Monster theMonster, Scanner scan) {
	
	char[] pause = {'p'};
	System.out.println(theHero.getName() + " battles " +
						theMonster.getName());
	System.out.println("---------------------------------------------");

	//do battle
	while (theHero.isAlive() && theMonster.isAlive() && pause[0] != 'q')
	{
		theHero.clearPotionEffects();
	    //hero goes first
		theHero.battleChoices(theMonster, scan);

		GameStateManager.pauseTime(1);
		//monster's turn (provided it's still alive!)
		if (theMonster.isAlive())
		    theMonster.attack(theHero);

		GameStateManager.pauseTime(1);
		//let the player bail out if desired
		System.out.print("\n-->q to quit, anything else to continue: ");
		pause = scan.next().toCharArray();

	}//end battle loop

	if (!theMonster.isAlive())
	    System.out.println(theHero.getName() + " was victorious!");
	else if (!theHero.isAlive())
		System.out.println(theHero.getName() + " was defeated :-(");
		
	else//both are alive so user quit the game
		System.out.println("Quitters never win ;-)");
	}
}
