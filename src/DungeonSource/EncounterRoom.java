package DungeonSource;

public class EncounterRoom extends Room{

	@Override
	public void triggerRoom() {
		generateEncounter();
	}
	
	public void generateEncounter() {
		System.out.println(MonsterFactory.createMonster(2).getName());
		
	}

}
