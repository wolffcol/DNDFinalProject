package DungeonSource;

public class ConcreteMinotaur extends Monster {

	public ConcreteMinotaur()
	{
		super("Concrete Minotaur: Purloiner of Generality", 200, 2, .6, .1, 30, 50, 30, 50);


    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " slowly swings a club toward's " +
							opponent.getName() + ":");
		super.attack(opponent);

	}//end override of attack


}//end Monster class
