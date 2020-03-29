package dungeon;

public class ItemRoom extends Room{
	
	private char roomType = 'I';
	
	public void triggerRoom(Hero theHero) {
		generateItem(theHero);
	}
	
	public void generateItem(Hero theHero) {
		System.out.println("Created an item");
		int random = (int)(Math.random()*10) + 1;
		
		if(random <= 2) {
			System.out.println("You found an invisibility potion");
			theHero.getItemBag().addItem(new InvisibilityPotion(), theHero.getItemBag().combatBag);
		}else if(random > 2 && random <= 4) {
			System.out.println("You found an attack potion");
			theHero.getItemBag().addItem(new AttackPotion(), theHero.getItemBag().combatBag);
		}else if(random > 4 && random <= 6) {
			System.out.println("You found a vision potion");
			theHero.getItemBag().addItem(new VisionPotion(), theHero.getItemBag().nonCombatBag);
		}else if(random > 6 && random <= 8){
			System.out.println("You found a healing potion");
			theHero.getItemBag().addItem(new HealingPotion(), theHero.getItemBag().combatBag);
		}else {
			System.out.println("Chest explodes");
			theHero.adjustHitPoints((int)((Math.random()*40 -20) + 1)+20);
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
