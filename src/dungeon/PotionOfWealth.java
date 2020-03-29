package dungeon;

public class PotionOfWealth extends Items {
	
	private String name = "Potion of Wealth";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		System.out.println( theHero.getName() + " bribes " + opponent.getName() + " with a Potion of Wealth. " + opponent.getName() + " leaves.");
		opponent.setHitPoints(0);

	}

	@Override
	public String getName() {
		return name;
	}

}
