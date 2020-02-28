package DungeonSource;

import java.util.Scanner;

public class Fighter extends Hero {
	
	private int cooldownTimer = 0;
	private int timerMax = 10;

	public Fighter()
	{
		super("Fighter", 100, 5, .8, 40, 75, .1);

    }//end constructor

	public void actionSurge()
	{
		cooldownTimer = timerMax;
		setTurns(getTurns());
		System.out.println(getName() + " doubled turns!");

	}//end

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " punches with lightning speed at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

    public void battleChoices(DungeonCharacter opponent, Scanner scan)
    {
		super.battleChoices(opponent, scan);

		do
		{
		    System.out.println("1. Attack Opponent\n"
		    				 + "   Deal Damage");
		    if(cooldownTimer <= 0) {
		    System.out.println("2. Use Action Surge\n"
		    				 + "   Doubles Current Turns-10 Turn Cooldown-Persistent");
		    }
		    if(!super.getItemBag().combatBag.isEmpty()) {
		    	System.out.println("3. Use an Item");
		    }
		    System.out.print("Choose an option: ");

		    switch (scan.nextInt())
		    {
			    case 1: attack(opponent);
			    	setTurns(-1);
			    	cooldownTimer--;
			        break;
			    case 2: if(cooldownTimer <= 0) {
			    			actionSurge();
			    		}
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

