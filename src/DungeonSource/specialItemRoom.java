package DungeonSource;

public class specialItemRoom extends Room{

	@Override
	public void triggerRoom(Hero theHero) {
		gainPillarOfOO(theHero);	
	}

	private void gainPillarOfOO(Hero theHero) {
		
		if(!theHero.hadAbstraction) {
			System.out.println("You have acquired the Artifact of Abstraction! 3 More to Go!");
			theHero.getItemBag().addItem(new Abstraction());
			theHero.hadAbstraction = true;
		}else if(theHero.hadAbstraction) {
			System.out.println("You have acquired the Artifact of Polymorphism! 2 More to Go!");
			theHero.getItemBag().addItem(new Polymorphism());
			theHero.hadPolymorphism = true;
		}else if(theHero.hadPolymorphism) {
			System.out.println("You have acquired the Artifact of Inheritance! 1 More to Go!");
			theHero.getItemBag().addItem(new Inheritance());
			theHero.hadInheritance = true;
		}else if(theHero.hadInheritance) {
			System.out.println("You have acquired the Artifact of Encapsulation! Time to Leave!");
			theHero.getItemBag().addItem(new Encapsulation());
			theHero.hadEncapsulation = true;
		}else {
			
		}
		
	}

}
