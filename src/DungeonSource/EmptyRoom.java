package DungeonSource;

public class EmptyRoom extends Room{

	@Override
	public void triggerRoom(Hero theHero) {
		System.out.println("The room looks empty");
		
	}

}
