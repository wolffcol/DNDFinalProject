package dungeon;

public class Abstraction extends Items {

	private String name = "Artifact of Abstraction";
	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		System.out.println("For a moment, " + theHero.getName() + " becomes intangible and ceases to exist in a physical form.");
		theHero.setBlock(1);
	}

	@Override
	public String getName() {
		
		return name;
	}

}
