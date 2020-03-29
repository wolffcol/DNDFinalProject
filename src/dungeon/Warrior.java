package dungeon;


public class Warrior extends Hero
{

    public Warrior()
	{
		super("Warrior", 250, 4, .8, 35, 60, .2);

    }//end constructor

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

	@Override
	public void special(DungeonCharacter opponent) {
		SpellPool.crushingBlow(opponent);
		
	}

}//end Hero class