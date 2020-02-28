package DungeonSource;

import java.util.Scanner;

public class Warrior extends Hero
{

    public Warrior()
	{
		super("Warrior", 125, 4, .8, 35, 60, .2);

    }//end constructor


	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.adjustHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

    public void battleChoices(DungeonCharacter opponent, Scanner scan)
    {
		super.battleChoices(opponent, scan);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
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
			    case 2: crushingBlow(opponent);
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