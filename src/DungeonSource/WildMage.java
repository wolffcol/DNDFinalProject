package DungeonSource;

import java.util.Scanner;

public class WildMage extends Hero {

	public WildMage()
	{
		super("Wild Mage", 75, 4, .8, 30, 60, .05);

    }//end constructor

	public void wildMagic(DungeonCharacter opponent)
	{
		int magicDamage = (int)(((Math.random() * 200-1) + 1)+1);
		System.out.println(getName() + " shoots random magic for " + magicDamage
									 + " damage!");
		opponent.adjustHitPoints(magicDamage);

	}

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a staff at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

    public void battleChoices(DungeonCharacter opponent, Scanner scan)
    {
		super.battleChoices(opponent, scan);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Wild Magic");
		    if(super.getItemBag().combatBag.isEmpty()) {
		    	
		    }else {
		    	System.out.println("3. Use an Item");
		    }
		    System.out.print("Choose an option: ");

		    switch (scan.nextInt())
		    {
			    case 1: attack(opponent);
			    	setTurns(-1);
			        break;
			    case 2: wildMagic(opponent);
			    	setTurns(-1);
			        break;
			    case 3: useCombatItem(this, opponent);
			    	System.out.println("Using an item is a free action!\n");
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch
		    
			if (getTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getTurns());

		} while(getTurns() > 0  && getHitPoints() > 0 && opponent.getHitPoints() > 0);

    }//end battleChoices method

}//end Hero class
