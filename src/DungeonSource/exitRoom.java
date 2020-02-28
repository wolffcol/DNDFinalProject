package DungeonSource;

public class exitRoom extends Room{

	@Override
	public void triggerRoom(Hero theHero) {
		if(theHero.hadAbstraction == true && theHero.hadEncapsulation == true && theHero.hadInheritance == true && theHero.hadPolymorphism == true) {
			GameStateManager.winGame();
		}else {
			System.out.println("You must collect the four artifacts of OO before exiting the dungeon.");
		}	
	}

}
