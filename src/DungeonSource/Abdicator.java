package DungeonSource;

public class Abdicator extends Monster {
	
	public Abdicator()
	{
		super("Abdicator: The Abandoned One", 200, 2, .6, .1, 30, 50, 30, 50);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end Monster class
