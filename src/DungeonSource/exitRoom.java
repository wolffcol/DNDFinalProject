package DungeonSource;

public class exitRoom extends Room{

	@Override
	public void triggerRoom(Hero theHero) {
		if(theHero.hadAbstraction == true && theHero.hadEncapsulation == true && theHero.hadInheritance == true && theHero.hadPolymorphism == true) {
			GameStateManager.winGame();
		}
		
	}

}
