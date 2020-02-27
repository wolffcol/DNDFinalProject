package DungeonSource;

public class Polymorphism extends Items {
	
	private String name = "Artifact of Polymorphism";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		ItemBag tempBag = theHero.itemBag;
		theHero = HeroFactory.createHero(GameStateManager.getScanner());
		theHero.itemBag = tempBag;
	}

	@Override
	public String getName() {
		return name;
	}

}