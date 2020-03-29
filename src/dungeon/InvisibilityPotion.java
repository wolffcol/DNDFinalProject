package dungeon;

public class InvisibilityPotion extends Items {
	
	private String name = "Invisibility Potion";
	
	public String getName() {
		return name;
	}
	
	public void useItem(Hero theHero, DungeonCharacter theMonster) {
		theHero.setBlock(1);
		System.out.println("\nYou now have 100% chance to block for 1 turn!");	
	}
	
	

}
