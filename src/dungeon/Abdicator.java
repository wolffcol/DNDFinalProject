package dungeon;

public class Abdicator extends Monster {
	
	public Abdicator()
	{
		super("Abdicator: The Abandoned One", 200, 4, .6, .5, 30, 50, 30, 40);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " wonders if " + opponent.getName() + " is truly a child of DungeonCharacter. Swings wildly in thought:");
		super.attack(opponent);

	}//end override of attack


}//end Monster class
