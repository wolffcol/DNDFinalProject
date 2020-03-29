package dungeon;

public class EncounterRoom extends Room{
	
	private char roomType = 'M';

	@Override
	public void triggerRoom(Hero theHero) {
		generateEncounter(theHero);
	}
	
	public void generateEncounter(Hero theHero) {
		Battle.BattleInstance(theHero, MonsterFactory.createMonster((int)(Math.random() * 3) + 1), GameStateManager.getScanner());
		
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
