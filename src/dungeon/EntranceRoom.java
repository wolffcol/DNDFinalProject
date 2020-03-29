package dungeon;

public class EntranceRoom extends Room {

	private char roomType = 'N';
	@Override
	public void triggerRoom(Hero theHero) {
			
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
