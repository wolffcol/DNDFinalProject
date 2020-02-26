package DungeonSource;

public class ItemRoom extends Room{
	
	public ItemRoom() {
		
	}
	
	public void triggerRoom() {
		generateItem();
	}
	
	public Items generateItem() {
		System.out.println("Created an item");
		int random = (int)(Math.random()*10) + 1;
		
		if(random <= 2) {
			return new InvisibilityPotion();
		}else if(random > 2 || random <= 4) {
			return new AttackPotion();
		}else if(random > 4 || random <= 6) {
			return new VisionPotion();
		}else if(random > 6 || random <= 8){
			return new HealingPotion();
		}else {
			System.out.println("Chest explodes");
			return null;
		}
	}

}
