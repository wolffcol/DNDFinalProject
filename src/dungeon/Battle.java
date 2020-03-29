package dungeon;

import java.util.Scanner;

public class Battle {
	
	static EquipmentFactory factory = new EquipmentFactory();
	
	public static void battleChoices(DungeonCharacter opponent)
	{
		Hero theHero = GameStateManager.getHero();
		theHero.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Use Special Ability");
		    if(theHero.getItemBag().combatBag.isEmpty()) {
		    	
		    }else {
		    	System.out.println("3. Use an Item");
		    }
		    System.out.print("Choose an option: ");
		    switch (GameStateManager.getInt())
		    {
			    case 1: theHero.attack(opponent);
			    	theHero.setTurns(-1);
			    	theHero.setCooldown(theHero.getCooldown() - 1);
			        break;
			    case 2: if(theHero.getCooldown() <= 0) {
	    				theHero.special(opponent);
	    				theHero.setTurns(-1);
			    		break;
	    				}	
			    case 3: theHero.useCombatItem(theHero, opponent);
			    	System.out.println("Using an item is a free action!\n");
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch
		    
			if (theHero.getTurns() > 0)
			    System.out.println("Number of turns remaining is: " + theHero.getTurns());

		} while(theHero.getTurns() > 0  && theHero.getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end overridden method
	
	public static void BattleInstance(Hero theHero, Monster theMonster, Scanner scan) {
	
		char[] pause = {'p'};
		System.out.println(theHero.getName() + " battles " +
						   theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause[0] != 'q')
		{
			theMonster.setHealStatus();
			theHero.clearPotionEffects();
			//hero goes first
			battleChoices(theMonster);

			GameStateManager.pauseTime(1);
			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			GameStateManager.pauseTime(1);
			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = scan.next().toCharArray();

		}//end battle loop

		if (!theMonster.isAlive()) {
			System.out.println(theHero.getName() + " was victorious!");
			Equipment eq = battleRewards();
			if(eq != null) {
				eq.equipItem();
				System.out.println("Battle reward is " + eq.getDescription() +"\n");
			}else {
			System.out.println("Battle reward is...nothing\n");
			}
		}
		else if (!theHero.isAlive()) {
			System.out.println(theHero.getName() + " was defeated :-(");
		}
		else {
			System.out.println("Quitters never win ;-)");
		}
	}
	
	private static Equipment battleRewards() {
		int random = (int)(Math.random()*2) + 1;
		
		if(random == 1) {
			return factory.generateEquipment();
		}else {
			return null;
		}
	}
}
