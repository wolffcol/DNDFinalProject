package DungeonSource;

import java.util.Scanner;

public class Fighter extends Hero {
	
	private boolean skillCooldown = false;

	public Fighter()
	{
		super("Fighter", 125, 4, .8, 35, 60, .2);

    }//end constructor


	public void actionSurge()
	{
		skillCooldown = true;
		setTurns(getTurns());
		System.out.println(name + " has gained twice as many turns");

	}//end

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

    public void battleChoices(DungeonCharacter opponent, Scanner scan)
    {
		super.battleChoices(opponent, scan);

		do
		{
		    System.out.println("1. Attack Opponent");
		    if(!skillCooldown) {
		    System.out.println("2. Use Action Surge");
		    }
		    if(super.getItemBag().itemBag.isEmpty()) {
		    	
		    }else {
		    	System.out.println("3. Use an Item");
		    }
		    System.out.print("Choose an option: ");

		    switch (scan.nextInt())
		    {
			    case 1: attack(opponent);
			    	setTurns(-1);
			        break;
			    case 2: actionSurge();
			        break;
			    case 3: useItem(this, opponent);
			    	System.out.println("Using an item is a free action!\n");
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch
		    
			if (getTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getTurns());

		} while(getTurns() > 0  && hitPoints > 0 && opponent.getHitPoints() > 0);
		skillCooldown = false;
    }//end battleChoices method

}//end Hero class

