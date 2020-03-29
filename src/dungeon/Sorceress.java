package dungeon;


public class Sorceress extends Hero implements Attack
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;


    public Sorceress()
	{
		super("Sorceress", 150, 5, .7, 25, 50, .3);
    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " casts a spell of fireball at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}

	@Override
	public void special(DungeonCharacter opponent) {
		SpellPool.heal();	
	}

}