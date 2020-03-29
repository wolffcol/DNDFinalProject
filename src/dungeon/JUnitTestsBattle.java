package dungeon;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class JUnitTestsBattle {
	
	Hero theHero;
	DungeonCharacter opponent;

	@BeforeEach
	public void setUp() throws Exception {
		theHero = new WildMage();
		opponent = new Skeleton();
	}
	//Done
	public void testDamageAndHealing() {
		theHero.adjustHitPoints(35);
		assertEquals(150-35, theHero.getHitPoints());
		theHero.adjustHitPoints(-35);
		assertEquals(150, theHero.getHitPoints());
	}
	
	//Done
	public void testSaveAndLoad() {
		Caretaker caretaker = new Caretaker();
		Originator originator = new Originator();
		
		//Base state of Saved States are null values
		Memento baseState = new Memento(new State(null,null,null));
		assertEquals(baseState, caretaker.get(0));
		
		Memento memState = new Memento(new State(theHero, null, null));
		originator.setState();
		caretaker.add(memState, 0);
		
		//Two save files
		assertEquals(memState, caretaker.get(0));
		assertEquals(baseState, caretaker.get(1));
	}

}
