package dungeon;

public class SpecialItemRoom extends Room{
	
	private char roomType = 'P';
	
	@Override
	public void triggerRoom(Hero theHero) {
		gainPillarOfOO(theHero);	
	}
	
	public char getRoomType() {
		if(characterHasBeenHere || temporaryReveal) {
			return roomType;
		}else {
			return ' ';
		}
	}

	private void gainPillarOfOO(Hero theHero) {
		
		if(!theHero.hadAbstraction) 
		{
			System.out.println("You have acquired the Artifact of Abstraction! 3 More to Go!");
			
			theHero.getItemBag().addItem(new Abstraction(), theHero.getItemBag().combatBag);
			theHero.hadAbstraction = true;
			GameStateManager.pauseTime(2);
			System.out.println("\nWHERE DO YOU THINK YOU ARE GOING PUNY HUMAN?\n");
			GameStateManager.pauseTime(1);
			Battle.BattleInstance(theHero, new ConcreteMinotaur(), GameStateManager.getScanner());
			
		}else if(!theHero.hadPolymorphism)
		{
			System.out.println("You have acquired the Artifact of Polymorphism! 2 More to Go!");
			
			theHero.getItemBag().addItem(new Polymorphism(), theHero.getItemBag().nonCombatBag);
			theHero.hadPolymorphism = true;
			GameStateManager.pauseTime(2);
			System.out.println("\nHow dare you presume to know!\n");
			GameStateManager.pauseTime(1);
			Battle.BattleInstance(theHero, new TheOne(), GameStateManager.getScanner());
			
		}else if(!theHero.hadInheritance) 
		{
			System.out.println("You have acquired the Artifact of Inheritance! 1 More to Go!");
			
			theHero.getItemBag().addItem(new Inheritance(), theHero.getItemBag().combatBag);
			theHero.hadInheritance = true;
			GameStateManager.pauseTime(2);
			System.out.println("\nDo you think I will let you so easily steal my birthright?\n");
			GameStateManager.pauseTime(1);
			Battle.BattleInstance(theHero, new Abdicator(), GameStateManager.getScanner());
			
		}else if(!theHero.hadEncapsulation) 
		{
			System.out.println("You have acquired the Artifact of Encapsulation! Time to Leave!");
			
			theHero.getItemBag().addItem(new Encapsulation(), theHero.getItemBag().combatBag);
			theHero.hadEncapsulation = true;
			GameStateManager.pauseTime(2);
			System.out.println("\nAn exposed being appears..." + theHero.getName() + " is confused.\n");
			GameStateManager.pauseTime(1);
			Battle.BattleInstance(theHero, new EncapsulationBoss(), GameStateManager.getScanner());
			
		}else {
			
		}	
	}
}
