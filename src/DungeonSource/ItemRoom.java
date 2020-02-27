package DungeonSource;

public class ItemRoom extends Room{
	
	public void triggerRoom(Hero theHero) {
		generateItem(theHero);
	}
	
	public void generateItem(Hero theHero) {
		System.out.println("Created an item");
		int random = (int)(Math.random()*10) + 1;
		
		if(random <= 2) {
			System.out.println("You found an invisibility potion");
			theHero.getItemBag().addItem(new InvisibilityPotion());
		}else if(random > 2 || random <= 4) {
			System.out.println("You found an attack potion");
			theHero.getItemBag().addItem(new AttackPotion());
		}else if(random > 4 || random <= 6) {
			System.out.println("You found a vision potion");
			theHero.getItemBag().addItem(new VisionPotion());
		}else if(random > 6 || random <= 8){
			System.out.println("You found a healing potion");
			theHero.getItemBag().addItem(new HealingPotion());
		}else {
			System.out.println("Chest explodes");
			theHero.subtractHitPoints(40);
		}
	}

}
