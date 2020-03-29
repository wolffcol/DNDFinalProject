package dungeon;

public class HealingPotion extends Items{
	
	private String name = "Healing Potion";
	private int max = 30;
	private int min = 10;

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		theHero.adjustHitPoints(-((int)((Math.random()*(max)-(min))+1)+(min)));	
	}

	@Override
	public String getName() {
		return name;
	}

}
