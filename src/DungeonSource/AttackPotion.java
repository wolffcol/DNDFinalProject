package DungeonSource;

public class AttackPotion extends Items {
	
	private String name = "Attack Potion";
	
	public String getName() {
		return name;
	}
	public void useItem() {
		System.out.println("I used an attack potion");
	}

}
