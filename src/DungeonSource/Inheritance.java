package DungeonSource;

public class Inheritance extends Items{
	
	private String name = "Artifact of Inheritance";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		theHero.getItemBag().addItem(new PotionOfWealth());	
	}

	@Override
	public String getName() {
		return name;
	}

}
