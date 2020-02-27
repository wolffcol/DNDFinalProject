package DungeonSource;

import java.util.Scanner;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private double trueBlock;
	private int numTurns;
	private ItemBag itemBag = new ItemBag();
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
  		itemBag.addItem(new VisionPotion());
  		itemBag.addItem(new VisionPotion());
  		itemBag.addItem(new VisionPotion());
  		itemBag.addItem(new HealingPotion());
  		itemBag.addItem(new Polymorphism());
  	}else if(this.getClass().toString().contains("Sorceress")) {
  		itemBag.addItem(new VisionPotion());
  	}else if(this.getClass().toString().contains("Thief")) {
  		itemBag.addItem(new InvisibilityPotion());
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
		name = Keyboard.readString();
  }//end readName method

  public ItemBag getItemBag() {
	  return itemBag;
  }

  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method

public void adjustHitPoints(int hitPoints)
	{
		if (hitPoints < 0){
			super.adjustHitPoints(hitPoints);
		}
		else if(defend())
		{
			System.out.println(name + " BLOCKED the attack!");
		}
		else
		{
			super.adjustHitPoints(hitPoints);
		}


	}//end method

public void useItem(Hero theHero, DungeonCharacter opponent) {
	
	itemBag.printItemList();
	int choice = -1;
	
	
	do {
		System.out.println("Which item would you like to use: ");
		choice = Keyboard.readInt();
	
	}while(choice > itemBag.getItemArrayList().size() || choice < 1);
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
			    case 1: MovementController.movement(scan);
			        break;
			    case 2: useItem(this, null);
			        break;
			    default:
			        System.out.println("Choose Again \n=================\n");
		    }//end switch

		} while(choice != 1 || choice != 2);
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


	public void setItemBag(ItemBag tempBag) {
		this.itemBag = tempBag;
		
	}

}//end Hero class