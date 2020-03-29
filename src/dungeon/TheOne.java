package dungeon;

public class TheOne extends Monster {
	
	public TheOne()
	{
		super("The One: Knower of Thyself", 100, 6, 1, .2, 20, 25, 25, 50);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " attempts to convince " +
							opponent.getName() + " to suffer damage:");
		super.attack(opponent);

	}//end override of attack


}//end Monster class
