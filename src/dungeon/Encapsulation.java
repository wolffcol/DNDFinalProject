package dungeon;

public class Encapsulation extends Items {
	
	private String name = "Artifact of Encapsulation";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		System.out.println( theHero.getName() + " generates an unpenetrable shield of protection.");	
	}

	@Override
	public String getName() {
		return name;
	}

}
