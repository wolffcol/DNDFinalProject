package dungeon;

public class Thief extends Hero implements Attack
{

    public Thief()
	{
		super("Thief", 150, 6, .8, 20, 40, .5);

    }//end constructor

    public void attack(DungeonCharacter opponent) {
    	
    	System.out.println(getName() + " thrusts a blade at " +
				opponent.getName() + ":");
    	
    	super.attack(opponent);
    }

	@Override
	public void special(DungeonCharacter opponent) {
		SpellPool.surpriseAttack(opponent);
		
	}
}