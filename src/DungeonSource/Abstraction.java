package DungeonSource;

public class Abstraction extends Items {

	private String name = "Artifact of Abstraction";
	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		theHero.getItemBag().addItem(new InvisibilityPotion(), theHero.getItemBag().combatBag);	
	}

	@Override
	public String getName() {
		
		return name;
	}

}
