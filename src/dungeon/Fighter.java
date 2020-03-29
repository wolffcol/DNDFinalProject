package dungeon;

public class Fighter extends Hero implements Attack{

	public Fighter()
	{
		super("Fighter", 200, 5, .8, 30, 60, .1);

    }
	
	public void special(DungeonCharacter opponent) {
		SpellPool.actionSurge();
	}

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " punches with lightning speed at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

}//end Hero class

