package DungeonSource;

import java.util.Scanner;

public class Thief extends Hero
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);

    }//end constructor

	public void surpriseAttack(DungeonCharacter opponent)
	{
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								getName() + " gets an additional turn.");
			setTurns(1);
			attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    attack(opponent);


	}//end surpriseAttack method


    public void battleChoices(DungeonCharacter opponent, Scanner scan)
	{
		super.battleChoices(opponent, scan);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Surprise Attack");
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
			    case 2: surpriseAttack(opponent);
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

    }
}