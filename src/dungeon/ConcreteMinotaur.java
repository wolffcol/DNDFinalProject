package dungeon;

public class ConcreteMinotaur extends Monster {

	public ConcreteMinotaur()
	{
		super("Concrete Minotaur: Purloiner of Generality", 400, 2, .4, 0, 60, 75, 30, 50);

    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " chucks a concrete block in " + opponent.getName() + "'s direction: ");
		super.attack(opponent);

	}
}
