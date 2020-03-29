package dungeon;

public class HeroFactory {
	
	
	public static Hero createHero() {
		
		
		System.out.println("Choose a hero:\n" +
			       "1. Warrior\n      Special Ability Crushing Blow\n" +
				   "2. Sorceress\n      Special Ability Heal\n" +
				   "3. Thief\n      Special Ability Sneak Attack\n" + 
				   "4. Fighter\n      Special Ability Action Surge\n" +
				   "5. Wild Mage\n      Special Ability Wild Magic\n");
		
		int choice = GameStateManager.getInt();
		
		switch(choice)
		{
			case 1: return new Warrior();

			case 2: return new Sorceress();

			case 3: return new Thief();
			
			case 4: return new Fighter();
			
			case 5: return new WildMage();

			default: System.out.println("invalid choice, returning Wild Mage");
				     return new WildMage();
		}
	}

}
