package dungeon;

public class AttackPotion extends Items {
	
	private String name = "Attack Potion";
	
	public String getName() {
		return name;
	}
	public void useItem(Hero theHero, DungeonCharacter theMonster) {
		System.out.println("You attack at Instant Speed!\n");
		theHero.attack(theMonster);
	}

}
