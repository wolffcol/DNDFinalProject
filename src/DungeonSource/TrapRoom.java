package DungeonSource;

public class TrapRoom extends Room{
	
	
	@Override
	public void triggerRoom(Hero theHero) {
		trapType(theHero);		
	}

		
	public void trapType(Hero theHero) {
		int type = (int)(Math.random()*3)+1;
		
		switch(type) {
			case 1:
				System.out.println("Fall into a spike trap! Lose 20 Health.");
				theHero.subtractHitPoints(20);
				break;
			case 2:
				System.out.println("Character falls into a healing fountain. Recover 20 Health.");
				theHero.subtractHitPoints(-20);
				break;
			case 3:
				System.out.println("You trip and drop your items into a black hole. Lose all your items.");
				theHero.getItemBag().getItemArrayList().clear();
				break;
			default:
				System.out.println("Fall into a spike trap!. Lose 20 Health.");
				theHero.subtractHitPoints(20);
		}
	}

}
