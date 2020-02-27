package DungeonSource;

public class TheOne extends Monster {
	
	public TheOne()
	{
		super("The One: Knower of Thyself", 200, 2, .6, .1, 30, 50, 30, 50);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end Monster class
