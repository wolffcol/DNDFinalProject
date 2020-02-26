package DungeonSource;

public class InvisibilityPotion extends Items {
	
	private String name = "Invisibility Potion";
	
	public String getName() {
		return name;
	}
	
	public void useItem(Hero theHero, DungeonCharacter theMonster) {
		theHero.chanceToBlock = 1.0;
		System.out.println("\nYou now have 100% chance to block for 1 turn!");	
	}
	
	

}
