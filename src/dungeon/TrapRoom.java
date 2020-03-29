package dungeon;

public class TrapRoom extends Room{
	
	private char roomType = 'T';
	
	private int pitMaxDmg = 20;
	private int pitMinDmg = 1;
	private int fountainHealMax = 40;
	private int fountainHealMin = 20;
	
	
	@Override
	public void triggerRoom(Hero theHero) {
		trapType(theHero);		
	}
	
	public void trapType(Hero theHero) {
		int type = (int)(Math.random()*3)+1;
		int damage;
		
		switch(type) {
			case 1:
				damage = (int)(((Math.random() * pitMaxDmg - pitMinDmg) + 1 ) + pitMinDmg);
				System.out.println("Fall into a spike trap! Lose " + damage + " Health.");
				theHero.adjustHitPoints(damage);
				break;
			case 2:
				int heal = (int)(((Math.random() * fountainHealMax - fountainHealMin)+1) + fountainHealMin);
				System.out.println("Drank from a mysterious fountain. Gain " + heal + " Health.");
				theHero.adjustHitPoints(-heal);
				break;
			case 3:
				System.out.println("You trip and drop your items into a black hole. Lose all your items.");
				theHero.getItemBag().getCombatArrayList().clear();
				theHero.getItemBag().getNonCombatArrayList().clear();
				break;
			default:
				damage = (int)(Math.random()*20)+1;
				System.out.println("Fall into a spike trap! Lose " + damage + " Health.");
				theHero.adjustHitPoints(damage);
		}	
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
