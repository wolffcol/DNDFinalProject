package DungeonSource;

import java.util.Scanner;

/**
 * Title: Hero.java
 *
 * Description: Abstract base class for a hierarchy of heroes.  It is derived
 *  from DungeonCharacter.  A Hero has battle choices: regular attack and a
 *  special skill which is defined by the classes derived from Hero.
 *
 *  class variables (all are directly accessible from derived classes):
 *    chanceToBlock -- a hero has a chance to block an opponents attack
 *    numTurns -- if a hero is faster than opponent, their is a possibility
 *                for more than one attack per round of battle
 *
 *  class methods (all are public):
 *    public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
	  public void readName()
	  public boolean defend()
	  public void subtractHitPoints(int hitPoints)
	  public void battleChoices(DungeonCharacter opponent)

 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected double trueBlock;
	protected int numTurns;
	protected ItemBag itemBag = new ItemBag();
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
  	
  	if(this.getClass().toString().contains("Warrior")) {
  		itemBag.addItem(new AttackPotion());
  		itemBag.addItem(new VisionPotion());
  		itemBag.addItem(new InvisibilityPotion());
  		itemBag.addItem(new HealingPotion());
  		itemBag.addItem(new Polymorphism());
  	}else if(this.getClass().toString().contains("Sorceress")) {
  		itemBag.addItem(new VisionPotion());
  	}else if(this.getClass().toString().contains("Thief")) {
  		itemBag.addItem(new InvisibilityPotion());
  	}
  	
  }

  public void readName()
  {
		System.out.print("Enter character name: ");
		name = Keyboard.readString();
  }//end readName method

  public ItemBag getItemBag() {
	  return itemBag;
  }

  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

public void subtractHitPoints(int hitPoints)
	{
		if (hitPoints < 0){
			super.subtractHitPoints(hitPoints);
		}
		else if(defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

public void useItem(Hero theHero, DungeonCharacter opponent) {
	
	itemBag.printItemList();
	
	System.out.println("Which item would you like to use: ");
	
	int choice = Keyboard.readInt();
	itemBag.getItemArrayList().get(choice-1).useItem(theHero, opponent);
	
	itemBag.getItemArrayList().remove(choice-1);
		
}

	public void nonBattleChoices(Scanner scan) {
		
		int choice;
		do
		{
		    System.out.println("1. Move Rooms");
		    if(itemBag.itemBag.isEmpty()) {
		    	
		    }else {
		    	System.out.println("2. Use an Item");
		    }
		    System.out.print("Choose an option: ");

		    choice = scan.nextInt();
		    switch (choice)
		    {
			    case 1: movement(scan);
			        break;
			    case 2: useItem(this, null);
			        break;
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch

		} while(choice != 1 || choice != 2);
	}
	
	public void movement(Scanner scan) {
		
		int choice;
		
		int[] currentRoom = GameStateManager.getCurrentRoom();
		
		if(currentRoom[0] == 7 && currentRoom[1] == 7) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "East is a Wall\n"
					+ "3: West\n"
					+ "South is a Wall");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[0] == 0 && currentRoom[1] == 0) {
			System.out.println("Move: \n"
					+ "North is a wall\n"
					+ "2: East\n"
					+ "West is a wall\n"
					+ "4: South");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[0] == 7 && currentRoom[1] == 0) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "West is a wall\n"
					+ "South is a wall");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[0] == 0 && currentRoom[1] == 7) {
			System.out.println("Move: \n"
					+ "North is a wall\n"
					+ "East is a wall\n"
					+ "3: West\n"
					+ "4: South");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[1] == 0) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "West is a wall\n"
					+ "4: South");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[0] == 7) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "3: West\n"
					+ "South is a Wall");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[0] == 0) {
			System.out.println("Move: \n"
					+ "North is a wall\n"
					+ "2: East\n"
					+ "3: West\n"
					+ "4: South");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[1] == 7) {
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "East is a wall\n"
					+ "3: West\n"
					+ "4: South");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else if(currentRoom[0] != 0 && currentRoom[0] != 7 && currentRoom[1] != 0 && currentRoom[1] != 7){
			System.out.println("Move: \n"
					+ "1: North\n"
					+ "2: East\n"
					+ "3: West\n"
					+ "4: South");
			System.out.println("Choose an option: ");
			choice = scan.nextInt();
		}else {	
			choice = 0;
		}
		
		switch(choice) {
		
			case 1:
				GameStateManager.setCurrentRoom(currentRoom[0] - 1, currentRoom[1]);
				break;
			case 2:
				GameStateManager.setCurrentRoom(currentRoom[0], currentRoom[1] + 1);
				break;
			case 3:
				GameStateManager.setCurrentRoom(currentRoom[0], currentRoom[1] - 1);
				break;
			case 4:
				GameStateManager.setCurrentRoom(currentRoom[0] + 1, currentRoom[1]);
				break;
			default:
				System.out.println("Something broke");
		}	
			
	}


	public void battleChoices(DungeonCharacter opponent, Scanner scan)
	{
	    numTurns = attackSpeed/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices


	public void clearPotionEffects() {
		this.chanceToBlock = trueBlock;	
	}

}//end Hero class