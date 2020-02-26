package DungeonSource;

public class ItemRoom extends Room{
	
	public ItemRoom() {
		
	}
	
	public void openChest() {
		generateItem();
	}
	
	public Items generateItem() {
		int random = (int)Math.random()*10;
		
		if(random <= 2) {
			return new InvisibilityPotion();
		}else if(random > 2 || random <= 4) {
			return new AttackPotion();
		}else if(random > 4 || random <= 6) {
			return new VisionPotion();
		}else {
			System.out.println("Chest explodes");
			return null;
		}
	}

}
