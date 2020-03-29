package dungeon;

public class EncapsulationBoss extends Monster{
	
	public EncapsulationBoss()
	{
		super("Exhibitionist: Leader of Exposure", 50, 2, 0, 0, 30, 50, 30, 50);
		
    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " dares " +
							opponent.getName() + " to attack:");
		super.attack(opponent);

	}//end override of 
}
