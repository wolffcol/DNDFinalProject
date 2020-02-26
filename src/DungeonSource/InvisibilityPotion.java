package DungeonSource;

public class InvisibilityPotion extends Items {
	
	private String name = "Invisibility Potion";
	
	public String getName() {
		return name;
	}
	public void useItem() {
		System.out.println("I used an invisibility potion");	
	}

}
