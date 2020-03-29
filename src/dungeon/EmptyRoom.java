package dungeon;

public class EmptyRoom extends Room{

	private char roomType = 'E';
	@Override
	public void triggerRoom(Hero theHero) {
		System.out.println("The room looks empty");	
	}

	@Override
	public char getRoomType() {
		if(characterHasBeenHere || temporaryReveal) {
			return roomType;
		}else {
			return ' ';
		}
	}

}
