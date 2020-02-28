package DungeonSource;

import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private double trueBlock;
	private int numTurns;
	private ItemBag itemBag;
	protected boolean hadEncapsulation, hadAbstraction, hadPolymorphism, hadInheritance = false;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
	public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	{
		super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
		this.chanceToBlock = chanceToBlock;
		this.trueBlock = chanceToBlock;
		readName();
		createBag();
	}
  
  
	private void createBag() {
	  
		itemBag = new ItemBag();
  	
  		if(this.getClass().toString().contains("Warrior")) {
  			itemBag.addItem(new VisionPotion(), itemBag.getNonCombatArrayList());
  			itemBag.addItem(new VisionPotion(), itemBag.getNonCombatArrayList());
  			itemBag.addItem(new VisionPotion(), itemBag.getNonCombatArrayList());
  			itemBag.addItem(new HealingPotion(), itemBag.getCombatArrayList());
  			itemBag.addItem(new Polymorphism(), itemBag.getNonCombatArrayList());
  		}else if(this.getClass().toString().contains("Sorceress")) {
  			itemBag.addItem(new VisionPotion(), itemBag.getNonCombatArrayList());
  		}else if(this.getClass().toString().contains("Thief")) {
  			itemBag.addItem(new InvisibilityPotion(), itemBag.getNonCombatArrayList());
  		}
  	
	}

	public int getTurns() {
		return numTurns;
	}
  
	public void setTurns(int add) {
		numTurns += add;
	}
  
	public void setBlock(double block) {
		this.chanceToBlock = block;
	}
  
	public void readName()
	{
		System.out.print("Enter character name: ");
		setName(Keyboard.readString());
	}//end readName method

	public ItemBag getItemBag() {
		return itemBag;
	}

	public boolean defend()
	{
		return Math.random() <= chanceToBlock;

	}//end defend method

	public void adjustHitPoints(int hitPoints){
			if (hitPoints < 0){
				super.adjustHitPoints(hitPoints);
		}else if(defend()){
			System.out.println(getName() + " BLOCKED the attack!");
		}else{
			super.adjustHitPoints(hitPoints);
		}
	}//end method

	public void useCombatItem(Hero theHero, DungeonCharacter opponent) {
	
		itemBag.printItemList(itemBag.getCombatArrayList());;
		int choice = -1;
	
		do {
			System.out.println("Which item would you like to use: ");
			choice = Keyboard.readInt();
	
		}while(choice > itemBag.getCombatArrayList().size()+1 || choice < 1);
		
		if(choice == itemBag.getCombatArrayList().size()+1) {
		
		}else {
			itemBag.getCombatArrayList().get(choice-1).useItem(theHero, opponent);
			itemBag.getCombatArrayList().remove(choice-1);
		}
		
	}

	public void useNonCombatItem(Hero theHero, DungeonCharacter opponent) {
	
		itemBag.printItemList(itemBag.getNonCombatArrayList());
		int choice = -1;
	
	
		do {
			System.out.println("Which item would you like to use: ");
			choice = Keyboard.readInt();
	
		}while(choice > itemBag.getNonCombatArrayList().size()+1 || choice < 1);
	
		if(choice == itemBag.getNonCombatArrayList().size() + 1) {
		
		}else {
			itemBag.getNonCombatArrayList().get(choice-1).useItem(theHero, opponent);
			itemBag.getNonCombatArrayList().remove(choice-1);
		}
		
	}

	public void nonBattleChoices(Scanner scan) {
		
		int choice;
		do
		{
		    System.out.println("\n1. Move Rooms");
		    if(itemBag.nonCombatBag.isEmpty()) {
		    	
		    }else {
		    	System.out.println("2. Use an Item");
		    }
		    System.out.println("3. Check Status");
		    System.out.print("Choose an option: ");

		    choice = scan.nextInt();
		    switch (choice)
		    {
			    case 1: MovementController.movement(scan);
			    	break;
			    case 2: useNonCombatItem(this, null);
			        break;
			    case 3: System.out.println(this.toString());
			    	break;
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }

		} while((choice != 1 && choice != 2 && choice != 3) || this.isAlive());
	}

	public void battleChoices(DungeonCharacter opponent, Scanner scan)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices


	public void clearPotionEffects() {
		this.chanceToBlock = trueBlock;	
	}


	public void setItemBag(ItemBag tempBag) {
		this.itemBag = tempBag;
		
	}
	
	public int artifactCount() {
		int count = 0;
		for(Items i : itemBag.combatBag) {
			if(i.toString().contains("Artifact")) {
				count++;
			}
		}
		for(Items i : itemBag.nonCombatBag) {
			if(i.getName().contains("Artifact")) {
				count++;
				
			}
		}
		return count;
	}
	
	public String toString() {
		return "================" + 
				"\n Name: " + this.getName() + 
				"\n Class: " + this.getClass().toString().substring(20) +
				"\n Items: " + (itemBag.combatBag.size() + itemBag.nonCombatBag.size()) + 
				"\n Artifacts: " + artifactCount() + 
				"\n ===============";  
	}

}//end Hero class