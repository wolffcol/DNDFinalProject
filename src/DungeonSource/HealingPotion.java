package DungeonSource;

public class HealingPotion extends Items{
	
	private String name = "Healing Potion";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		theHero.adjustHitPoints(-20);	
	}

	@Override
	public String getName() {
		return name;
	}

}
