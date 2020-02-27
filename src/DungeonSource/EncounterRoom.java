package DungeonSource;

public class EncounterRoom extends Room{

	@Override
	public void triggerRoom(Hero theHero) {
		generateEncounter(theHero);
	}
	
	public void generateEncounter(Hero theHero) {
		Battle.BattleInstance(theHero, MonsterFactory.createMonster((int)(Math.random() * 3) + 1), GameStateManager.getScanner());
		
	}

}
