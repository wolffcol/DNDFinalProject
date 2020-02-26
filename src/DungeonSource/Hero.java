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
			    case 1: movement();
			    	
			        break;
			    case 2: useItem(this, null);
			    	
			        break;
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch

		} while(choice != 1 || choice != 2);
	}
	
	public void movement() {
		
		
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