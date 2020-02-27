package DungeonSource;

public class Encapsulation extends Items {
	
	private String name = "Artifact of Encapsulation";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		System.out.println( theHero.getName() + " generates a shield." + opponent.getName() + " cannot reach through the protection.");	
	}

	@Override
	public String getName() {
		return name;
	}

}
