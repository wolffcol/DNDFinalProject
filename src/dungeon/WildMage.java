package dungeon;


public class WildMage extends Hero {

	public WildMage()
	{
		super("Wild Mage", 150, 4, .8, 60, 60, .05);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a staff at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

	@Override
	public void special(DungeonCharacter opponent) {
		SpellPool.wildMagic(opponent);
		
	}

}//end Hero class
