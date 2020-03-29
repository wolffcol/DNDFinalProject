package dungeon;

public class Polymorphism extends Items {
	
	private String name = "Artifact of Polymorphism";

	@Override
	public void useItem(Hero theHero, DungeonCharacter opponent) {
		
		System.out.println("This is a Work-In-Progress item. Suppose to allow you to re-class or multiclass.");
		//ItemBag tempBag = theHero.getItemBag();
		//theHero = HeroFactory.createHero();
		//theHero.setItemBag(tempBag);
	}

	@Override
	public String getName() {
		return name;
	}

}
